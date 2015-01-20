package shoppingsolutionproject

import com.twocheckout.model.Authorization
import com.twocheckout.Twocheckout
import com.twocheckout.TwocheckoutCharge
import java.util.List;
import net.authorize.sim.*

import javax.jws.WebParam;
import javax.xml.bind.annotation.XmlElement;

import net.taxcloud.Address;
import net.taxcloud.ArrayOfCartItem;
import net.taxcloud.CartItem
import net.taxcloud.ExemptionCertificate;
import net.taxcloud.LookupRsp
import net.taxcloud.TaxCloudSoap
import wslite.soap.*

class ShoppingCartController {

    def shoppingCartService
	TaxCloudSoap taxCloud
	Random rand = new Random()
	
	def view(){
		def cart = shoppingCartItems()
		[cart:cart]
	}
	
	def checkout(){
		def shippingCost = 0
		def cart = shoppingCartItems()
		cart.each() {item ->
			def itemShippingCost = item.productInfo['shippingCost']
			def salePrice = item.productInfo['salePrice']
			if (itemShippingCost){
				shippingCost += itemShippingCost 
			}
		}
		[shipping: shippingCost]
	}
	
	def review(){
		
		def cart = shoppingCartItems()
		def subtotal
		def shippingCost
		(subtotal, shippingCost) = getCartSubtotal(cart)
		def cartItems
		Address billingAddress = new Address(
			address1: params.address1, address2: params.address2, 
			city: params.city, state: params.state, zip5:params.zip, zip4:'')
		Address shippingAddress = new Address(
			address1: params.shippingAddress1, address2: params.shippingAddress2, 
			city:params.shippingCity, state:params.shippingState, zip5:params.shippingZip, zip4:'')
		cartItems = compileArrayOfCartItem(cart)
		def addressValidationErrors = taxCloudAddressLookup(params.address1, params.address2, params.city, params.state, params.zip)
		def shippingValidationErrors = taxCloudAddressLookup(params.shippingAddress1, params.shippingAddress2, params.shippingCity, params.shippingState, params.shippingZip)
		if(addressValidationErrors){
			flash.message = "Invalid Billing Address Entered"
			redirect (action:'checkout', params:params)
		}
		if(shippingValidationErrors && !addressValidationErrors){
			flash.message = "Invalid Shipping Address Entered"
			redirect (action:'checkout', params: params)
		}
		session.setAttribute('billingAddress', billingAddress)
		session.setAttribute('shippingAddress', shippingAddress)
		session.setAttribute('firstName', params.firstName)
		session.setAttribute('lastName', params.lastName)
		def taxAmmt = getTaxAmmount(cartItems).round(2)
		def total = taxAmmt + shippingCost + subtotal
		[cart:cart, tax:taxAmmt, totalCost: total, name:params.name]
	}

	
	def authorizeDotNetCheckout(){
		def cart = shoppingCartItems()
		def subTotal
		def shippingCost
		(subTotal, shippingCost) = getCartSubtotal(cart)
		def cartItems = compileArrayOfCartItem(cart)
		def taxAmmt = getTaxAmmount(cartItems).round(2)
		def totalPrice = (subTotal + shippingCost + taxAmmt).toString()
		
		Fingerprint fingerprint = Fingerprint.createFingerprint(
		  grailsApplication.config.shoppingService.authorizeDotNet.apiLoginID,
		  grailsApplication.config.shoppingService.authorizeDotNet.transactionKey,
		  1234567890, // random sequence used for creating the fingerprint
		  totalPrice);
   
		long x_fp_sequence = fingerprint.getSequence();
		long x_fp_timestamp = fingerprint.getTimeStamp(	);
		String x_fp_hash = fingerprint.getFingerprintHash();
		
		[fingerprint: fingerprint, totalPrice: totalPrice]
	}
	
	def enter2CoPayment(){
		
	}
	
	def twoCheckoutCheckout(){

		def subTotal 
		def shippingCost
		def taxAmmt
		def confirmationNumber
		def cart = shoppingCartItems()
		Invoice customerInvoice
		
		Twocheckout.privatekey = grailsApplication.config.shoppingService.twoCheckout.privateKey;
		Twocheckout.mode = grailsApplication.config.shoppingService.twoCheckout.environment;
		
//		try {
			HashMap billing = new HashMap();
			billing.put("name", "Testing Tester");
			billing.put("addrLine1", "xvxcvxcvxcvcx");
			billing.put("city", "Columbus");
			billing.put("state", "Ohio");
			billing.put("country", "USA");
			billing.put("zipCode", "43230");
			billing.put("email", "tester@2co.com");
			billing.put("phoneNumber", "555-555-5555");
		
			HashMap request = new HashMap();
			request.put("sellerId", grailsApplication.config.shoppingService.twoCheckout.sellerId);
			request.put("merchantOrderId", "test123");
			request.put("token", params.token);
			request.put("currency", "USD");
			request.put("total", "1.00");
			request.put("billingAddr", billing);
		
			Authorization response = TwocheckoutCharge.authorize(request);
			confirmationNumber = response.getOrderNumber()
			(subTotal, shippingCost) = getCartSubtotal(cart)
			taxAmmt = getTaxAmmount(compileArrayOfCartItem(cart))
			customerInvoice = new Invoice(name: billing.name, shippingCost: shippingCost, subTotal: subTotal, tax: taxAmmt, confirmationNumber:confirmationNumber, fulfilled: false).save(flush:true)
			cart.each() {item ->
				def price = item.productInfo['salePrice'] ?: item.productInfo['retailPrice']
				def invoiceItem = new InvoiceItem(productNumber : item.productInfo['productNumber'], name: item.productInfo['name'], description: item.productInfo['description'], price: price, qty: shoppingCartService.getQuantity(Item.findByProductNumber(item.productInfo['productNumber'])))
				println invoiceItem
				customerInvoice.addToInvoiceItems(invoiceItem).save(flush: true)
			}
			//TODO: add order to customer and save
//		} catch (Exception e) {
//			String message = e.toString();
//			println message
//		}
		[customerInvoice: customerInvoice]
	}
	
	def addToCart(){
		def product = Item.findByProductNumber(params.productNumber)
		shoppingCartService.addToShoppingCart(product)
		render(text:'',contentType:'text/plain')
	}
	
	def itemInCart(){
		def cartHasItem = false
		def cart = shoppingCartItems()
		cart.each() { item ->
			if (item.productInfo['productNumber'].toString() == params.productNumber.toString()){
				cartHasItem = true
			} 
		}
		render(cartHasItem)
	}
	
	def removeFromCart(){
		def product = Item.findByProductNumber(params.productNumber)
		def qty = shoppingCartService.getQuantity(product)
		shoppingCartService.removeFromShoppingCart(product, qty)
		def cart = shoppingCartItems()
		render(cart)
	}
	
	def emptyCart(){
		shoppingCartService.emptyShoppingCart()
		redirect(controller: 'shoppingCart', action: 'view')
	}
	
	def updateQuantity(){
		def product = Item.findByProductNumber(params.productNumber)
		def currentQuantity = shoppingCartService.getQuantity(product).toInteger()
		def newQuantity = params.quantity.toInteger()
		if (currentQuantity > newQuantity){
			def difference = currentQuantity - newQuantity
			shoppingCartService.removeFromShoppingCart(product, difference)
		}
		else{
			def difference = newQuantity - currentQuantity 
			shoppingCartService.addToShoppingCart(product, difference)
		}
		def newPrice
		if (product.salePrice!=null){
			newPrice = String.format("%.2f", (shoppingCartService.getQuantity(product)*product.salePrice))
		}
		else{
			newPrice = String.format("%.2f", (shoppingCartService.getQuantity(product)*product.retailPrice))
		}
		render(newPrice)
	}
	
	def AddressLookup(){
		
	}
	
	public def getShoppingCart(){
		def cart = []
		def items = shoppingCartService.getItems()
		
		items?.sort { a, b -> a.id <=> b.id }.each { item ->
			def itemInfo = ['item': item,
					'qty':shoppingCartService.getQuantity(item)]

		cart.add(itemInfo)
		return cart
		}
	}
	
	public def getShippingCost(){
		def shippingCost=0
		def cart = shoppingCartItems();
		if (cart.isEmpty()){
			render(0.00)
		}
		else{
			cart.each(){item ->
				shippingCost += item.productInfo['shippingCost']*item.qty
			}
			render String.format("%.2f",shippingCost)
		}
	} 	
	
	private List shoppingCartItems() {
		def cart = []
				def items = getShoppingCart()
				if (items == null){
					items = []
				}
				items.each() { product ->
				cart.add('productInfo': com.metasieve.shoppingcart.Shoppable.findByShoppingItem(product),
						'qty' : shoppingCartService.getQuantity(product))
		}
		return cart
	}
	
	private def taxCloudAddressLookup(address1, address2, city, state, zip){
		def addressValidationErrors = taxCloud.verifyAddress(
			grailsApplication.config.shoppingService.taxCloud.uspsUserId,
			address1, address2, city, state, zip, '')
		return addressValidationErrors.errDescription
	}
	
	private compileArrayOfCartItem(List cart) {
		ArrayOfCartItem cartItems = new ArrayOfCartItem()
		cart.eachWithIndex {item, index ->
		def salePrice = item.productInfo['salePrice']
				def itemPrice
				if (salePrice){
					itemPrice = salePrice
				}
				else{
					itemPrice = item.productInfo['retailPrice']
				}
		def itemForLookup = Item.findByProductNumber(item.productInfo['productNumber'])
				CartItem ci = new CartItem(
						index: index, itemID: item.productInfo['productNumber'].toString(), tic: 91040, price: itemPrice, qty: shoppingCartService.getQuantity(itemForLookup).toInteger())
		cartItems.getCartItem().add(ci)
		}
		return cartItems
	}
	
	private getCartSubtotal(List cart) {
		def subTotal = 0
		def shippingCost = 0
		cart.eachWithIndex {item, index ->
			def salePrice = item.productInfo['salePrice']
			def itemPrice
			if (salePrice){
				itemPrice = salePrice
			}
			else{
				itemPrice = item.productInfo['retailPrice']
			}
			def itemForLookup = Item.findByProductNumber(item.productInfo['productNumber'])
			def quantity = shoppingCartService.getQuantity(itemForLookup).toInteger()
			subTotal += (itemPrice * quantity)
			def itemShipping = item.productInfo['shippingCost'] 
			if (itemShipping){
				shippingCost += (itemShipping) *item.qty		
			}
		}
		return [subTotal, shippingCost] 
	}
	
	private double getTaxAmmount(ArrayOfCartItem cartItems) {
		def originAddress = grailsApplication.config.shoppingService.taxCloud.origin
		Address origin = new Address(address1:originAddress.address1, address2:originAddress.address2 , city:originAddress.city, state:originAddress.state, zip5:originAddress.zip, zip4:'')
		
		LookupRsp lookUpResponse = taxCloud.lookup(
			grailsApplication.config.shoppingService.taxCloud.loginId, 
			grailsApplication.config.shoppingService.taxCloud.apiKey,
			session.getAttribute('firstName')+session.getAttribute('lastName'), 
			session.getAttribute('firstName')+session.getAttribute('lastName')+new Date().getDateTimeString(), 
			cartItems, 
			origin, 
			session.getAttribute('billingAddress'), 
			true, //delivered by seller 
			null) // tax exempt #
		def taxAmmts = lookUpResponse.cartItemsResponse.cartItemResponse.taxAmount
		def taxAmmt = 0
		taxAmmts.each {tax ->
			taxAmmt += tax
		}
		return taxAmmt
	}
}
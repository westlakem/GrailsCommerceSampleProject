package shoppingsolutionproject

import java.util.List;

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
		ArrayOfCartItem cartItems = new ArrayOfCartItem()
		def subTotal = 0
		def originAddress = grailsApplication.config.shoppingService.taxCloud.origin
		    Address origin = new Address(address1:originAddress.address1, address2:originAddress.address2 , city:originAddress.city, state:originAddress.state, zip5:originAddress.zip, zip4:'')
		Address billingAddress = new Address(
			address1: params.address1, address2: params.address2, 
			city: params.city, state: params.state, zip5:params.zip, zip4:'')
		Address shippingAddress = new Address(
			address1: params.shippingAddress1, address2: params.shippingAddress2, 
			city:params.shippingCity, state:params.shippingState, zip5:params.shippingZip, zip4:'')
		cart.eachWithIndex {item, index ->
			def itemShippingCost = item.productInfo['shippingCost']
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
		LookupRsp lookUpResponse = taxCloud.lookup(grailsApplication.config.shoppingService.taxCloud.loginId, grailsApplication.config.shoppingService.taxCloud.apiKey,
			params.name, params.name+new Date().getDateTimeString(), cartItems, origin, shippingAddress, true, null)
		def taxAmmts = lookUpResponse.cartItemsResponse.cartItemResponse.taxAmount
		def taxAmmt = 0
		taxAmmts.each {tax ->
			taxAmmt += tax
		}
		[cart:cart, tax:taxAmmt]
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
}
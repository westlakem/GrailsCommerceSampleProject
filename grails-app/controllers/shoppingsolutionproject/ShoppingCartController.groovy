package shoppingsolutionproject


import java.math.MathContext
import java.util.List;
import net.authorize.sim.*

import javax.jws.WebParam;
import javax.xml.bind.annotation.XmlElement;

import wslite.soap.*

class ShoppingCartController {

    def shoppingCartService
	def cartService
	def taxService
	def paymentService
	def taxCloud
	def springSecurityService
	
	def view(){
		def cart = cartService.shoppingCartItems(shoppingCartService)
		[cart:cart]	
	}
	
	def enterPayment(){
		def invoice = Invoice.get(params.invoiceNumber)
		def paymentToken
		if (invoice == null){
			flash.message = "I'm sorry, there was a problem accessing your stored cart.  Please empty the cart and try again"
			redirect (action:'view', params: params)
		}
		else{
			paymentToken = paymentService.generateToken(invoice)			
		}
		[invoice : invoice, paymentToken:paymentToken]
	}
	
	def paymentAuthorizing(){
		[params: params]
	}
	
	def authorizePayment(){
		def authSuccess
		def authorization
		def invoice = Invoice.get(params.invoiceNumber)
		if (invoice == null){
			flash.message = "I'm sorry, there was a problem accessing your stored cart.  Please empty the cart and try again"
			redirect (action:'enterPayment', params: params)
		}
		else{
			(authSuccess, authorization) = paymentService.authorizePayment(invoice, params)
			if (!authSuccess){
				flash.message = authorization['responseReasonText']
				redirect (action:'enterPayment', params: params)
			}
			else{
				def paymentOutcome = paymentService.capturePayment(invoice, params)
				if (paymentOutcome != 'SUCCESS'){
					flash.message = paymentOutcome
					redirect (action:'enterPayment', params: params)
				}
			shoppingCartService.emptyShoppingCart()
			}
		}
	}
	
	def checkout(){
		if(springSecurityService.isLoggedIn()){
			chain(action: checkoutAsAuthenticated)
		}
	}
	
	def checkoutAsAuthenticated(){
		def user = springSecurityService.getCurrentUser()
		def customer = Customer.findByUser(user)
		[customer: customer]
	}
	
	def checkoutAsGuest(){
		def shippingCost = 0
		def cart = cartService.shoppingCartItems(shoppingCartService)
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
		def cart
		def customerInvoice
		def shippingAddress
		def billingAddress
		def customerName
		if(springSecurityService.loggedIn()){
			def user = springSecurityService.getCurrentUser()
			def customer = Customer.findByUser(user)
			if (!customer){
				flash.message = "You must be logged in as a returning customer"
				redirect(action:'checkoutAsAuthenticated')
			}
			shippingAddress = customer.shippingAddresses.get(params.shippingAddressId)
			billingAddress = customer.billingAddresses.get(params.billingAddressId)
			customerName = customer.firstName + customer.lastName
			if(!(shippingAddress && billingAddress)){
				flash.message = """Billing or shipping address not associated with your account.
					Please inform us of this error."""
				redirect(action:'checkoutAsAuthenticated')
			}
		}
		else{
			shippingAddress = Address.findOrCreateByAddress1AndAddress2AndCityAndStateAndZipCode(
					params.shippingAddress1, params.shippingAddress2, params.shippingCity, params.shippingState, params.shippingZip).save()
			billingAddress = Address.findOrCreateByAddress1AndAddress2AndCityAndStateAndZipCode(
					params.address1, params.address2, params.city, params.state, params.zip).save(flush: true, failOnError: true)
			customerName = params.firstName+' '+params.lastName
		} 
		def addressValidationErrors = taxService.addressLookup(billingAddress)
		def shippingValidationErrors = taxService.addressLookup(shippingAddress)			
		if(addressValidationErrors){
			flash.message = "Invalid Billing Address Entered"
			redirect (action:'checkoutAsGuest', params:params)
		}
		if(shippingValidationErrors && !addressValidationErrors){
			flash.message = "Invalid Shipping Address Entered"
			redirect (action:'checkoutAsGuest', params: params)
		}
		(cart, customerInvoice) = createInvoice(customerName, billingAddress, shippingAddress)
		[cart:cart, invoice: customerInvoice]
	}
	
	def addToCart(){
		def product = Item.findByProductNumber(params.productNumber)
		shoppingCartService.addToShoppingCart(product)
		render(text:'',contentType:'text/plain')
	}
	
	def itemInCart(){
		def cartHasItem = false
		def cart = cartService.shoppingCartItems(shoppingCartService)
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
		def cart = cartService.shoppingCartItems(shoppingCartService)
		render(cart)
	}
	
	def emptyCart(){
		shoppingCartService.emptyShoppingCart()
		redirect(controller: 'shoppingCart', action: 'view')
	}
	
	def getShippingCost(){
		render(String.format("%.2f", cartService.shippingCost(shoppingCartService)))
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
	
	def invoiceTotal(){
		render(Invoice.get(params.invoiceId).total)
	}
	private def createInvoice (customerName, billingAddress, shippingAddress){
		def cart = cartService.shoppingCartItems(shoppingCartService)
		def subtotal = cartService.subtotal(cart, shoppingCartService)
		def taxAmmt = taxService.taxAmmount(cart, shippingAddress).round(2)
		def shippingCost = cartService.shippingCost(shoppingCartService)
		def total = taxAmmt + shippingCost + subtotal
		def customerInvoice = new Invoice(
				name: customerName,
				subtotal: subtotal,
				tax: taxAmmt,
				shippingCost: shippingCost,
				shippingAddress: shippingAddress,
				billingAddress: billingAddress,
				fulfilled: false,
				paid: false).save(flush:true, failOnError: true)
				cart.each() {item ->
				def price = item.productInfo['salePrice'] ?: item.productInfo['retailPrice']
						def invoiceItem = new InvoiceItem(productNumber : item.productInfo['productNumber'], name: item.productInfo['name'], description: item.productInfo['description'], price: price, qty: shoppingCartService.getQuantity(Item.findByProductNumber(item.productInfo['productNumber'])))
				customerInvoice.addToInvoiceItems(invoiceItem).save()
		}
		customerInvoice.save(flush:true)
		return [cart, customerInvoice]
	}
}
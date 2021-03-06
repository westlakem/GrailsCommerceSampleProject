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
		def shippable = false
		cart.each(){ item ->
			if(item.productInfo['shippable']){
				shippable = true
				return
			}
		}
		[cart:cart, shippable:shippable ]	
	}
	
	def enterPayment(){
		def invoice = Invoice.get(params.invoiceNumber)
		def paymentToken
		if (invoice == null){
			flash.message = "I'm sorry, there was a problem accessing your stored cart.  Please empty the cart and try again"
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
		def authorizationMessage
		(authSuccess, authorization, authorizationMessage) = paymentService.authorizeAndCapturePayment(request)
		if (!authSuccess){
			flash.message = authorizationMessage
		}
		else{
			shoppingCartService.emptyShoppingCart()
			println(params)
			def invoice = Invoice.get(authorization.invoiceId)
			if ((invoice == null) || (invoice.paid == true) || (invoice.total.toString() != authorization['paymentAmount'])){
				flash.message = "Payment has been processed but there was a problem processing your order."
			}
			else{
				invoice.paid = true
				invoice.paymentTrasactionId = authorization.transactionId
				invoice.save(flush:true)
				flash.message = "Thank you for your purchase"
			}
		}
	}
	
	def checkout(){
		if(springSecurityService.isLoggedIn()){
			chain(action: 'checkoutAsAuthenticated')
		}
	}
	
	def checkoutAsAuthenticated(){
		def user = springSecurityService.getCurrentUser()
		def customer = Customer.findByUser(user)
		if (customer==null){
			flash.message = 'Must be logged in as a customer or a guest to checkout'
			redirect(action: 'view')
		}
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
		if(springSecurityService.isLoggedIn()){
			def user = springSecurityService.getCurrentUser()
			def customer = Customer.findByUser(user)
			if (!customer){
				flash.message = "You must be logged in as a returning customer"
				redirect(action:'checkoutAsAuthenticated')
			}
			def sAddress = Address.get(params.shippingAddress)
			def bAddress = Address.get(params.billingAddress)
			shippingAddress = CustomerShippingAddress.findByAddressAndCustomer(sAddress, customer).address // validates address belongs to customer
			billingAddress = CustomerBillingAddress.findByAddressAndCustomer(bAddress, customer).address // validates address belogns to customer
			customerName = customer.firstName +' ' + customer.lastName
			if(!(shippingAddress && billingAddress)){
				flash.message = """Billing or shipping address not associated with your account.
					Please inform us of this error."""
				redirect(action:'checkoutAsAuthenticated')
			}
		}
		else{
			shippingAddress = Address.findOrCreateByAddress1AndAddress2AndCityAndStateAndZipCode(
					params.shippingAddress1, params.shippingAddress2, params.shippingCity, params.shippingState, params.shippingZip).save(flush:true)
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
		def shippable = false
		cart.each { item ->
			if(item.productInfo['shippable']){
				shippable = true
				return
			}
		}
		[cart:cart, invoice: customerInvoice, shippable: shippable]
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
		render(String.format("%.2f", cartService.shippingCost(shoppingCartService)) ?: 0.00)
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
		def user = springSecurityService.isLoggedIn()? springSecurityService.loadCurrentUser() : null
		def customer = user? Customer.findByUser(user) : null
		def cart = cartService.shoppingCartItems(shoppingCartService)
		def subtotal = cartService.subtotal(cart, shoppingCartService)
		def shippingCost = cartService.shippingCost(shoppingCartService)
		def customerInvoice = new Invoice(
				name: customerName,
				subtotal: subtotal,
				shippingCost: shippingCost,
				shippingAddress: shippingAddress,
				billingAddress: billingAddress,
				fulfilled: false,
				customer: customer,
				paid: false).save(flush: true)
		customerInvoice.tax = taxService.taxAmmount(cart, shippingAddress, customerInvoice).round(2)
		cart.each() {item ->
			def price = item.productInfo['salePrice'] ?: item.productInfo['retailPrice']
			def invoiceItem = new InvoiceItem(productNumber : item.productInfo['productNumber'], name: item.productInfo['name'], description: item.productInfo['description'], price: price, qty: shoppingCartService.getQuantity(Item.findByProductNumber(item.productInfo['productNumber'])))
			customerInvoice.addToInvoiceItems(invoiceItem).save()
		}
		customerInvoice.save(flush:true)
		return [cart, customerInvoice]
	}
}
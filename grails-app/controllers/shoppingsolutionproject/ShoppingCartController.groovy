package shoppingsolutionproject


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
	
	def view(){
		def cart = cartService.shoppingCartItems()
		[cart:cart]
	}
	
	def enterPayment(){
		def paymentToken = paymentService.generateToken()
		[invoiceId : params.invoiceNumber]
	}
	
	def paymentConfirmation(){
		def invoice = Invoice.get(params.invoiceNumber)
		if (invoice == null){
			render("I'm sorry, there was a problem accessing your stored cart.  Please empty the cart and try again")
		}
		def paymentOutcome = paymentService.processPayment(invoice, cartService.shoppingCartItems())
		if (paymentOutcome != 'SUCCESS'){
			flash.message = paymentOutcome
			redirect (action:'enterPayment', params: params)
		}
	}
	
	def checkout(){
		def shippingCost = 0
		def cart = cartService.shoppingCartItems()
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
		

		def addressValidationErrors = taxService.addressLookup(params.address1, params.address2, params.city, params.state, params.zip)
		def shippingValidationErrors = taxService.addressLookup(params.shippingAddress1, params.shippingAddress2, params.shippingCity, params.shippingState, params.shippingZip)
		if(addressValidationErrors){
			flash.message = "Invalid Billing Address Entered"
			redirect (action:'checkout', params:params)
		}
		if(shippingValidationErrors && !addressValidationErrors){
			flash.message = "Invalid Shipping Address Entered"
			redirect (action:'checkout', params: params)
		}
		def cart = cartService.shoppingCartItems()
		def subtotal = cartService.subtotal(cart)
		def taxAmmt = taxService.taxAmmount(cart).round(2)
		def shippingCost = cartService.shippingCost()
		def total = taxAmmt + shippingCost + subtotal
		Address shippingAddress = Address.findOrCreateBy(
				address1: params.shippingAddress1, address2: params.shippingAddress2, city: params.shippingCity, state: params.shippingState, zip:params.shippingZip)
		Address billingAddress = Address.findOrCreateBy(
				address1: params.address1, address2: params.address2, city: params.city, state: params.state, zip:params.zip)
		def customerInvoice = new Invoice(
			name: params.firstName+' '+params.lastName, 
			subtotal: subtotal, 
			tax: taxAmmt, 
			shippingCost: shippingCost, 
			shippingAddress: shippingAddress,
			billingAddress: billingAddress,
			fulfilled: false,
			paid: false).save(flush:true)
		cart.each() {item ->
			def price = item.productInfo['salePrice'] ?: item.productInfo['retailPrice']
			def invoiceItem = new InvoiceItem(productNumber : item.productInfo['productNumber'], name: item.productInfo['name'], description: item.productInfo['description'], price: price, qty: shoppingCartService.getQuantity(Item.findByProductNumber(item.productInfo['productNumber'])))
			customerInvoice.addToInvoiceItems(invoiceItem).save(flush: true)
		}
		[cart:cart, invoice: customerInvoice]
	}
	
	def addToCart(){
		def product = Item.findByProductNumber(params.productNumber)
		shoppingCartService.addToShoppingCart(product)
		render(text:'',contentType:'text/plain')
	}
	
	def itemInCart(){
		def cartHasItem = false
		def cart = cartService.shoppingCartItems()
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
		def cart = cartService.shoppingCartItems()
		render(cart)
	}
	
	def emptyCart(){
		shoppingCartService.emptyShoppingCart()
		redirect(controller: 'shoppingCart', action: 'view')
	}
	
	def getShippingCost(){
		render(cartService.shippingCost().round(2))
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
}
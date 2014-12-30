package shoppingsolutionproject

import java.util.List;

class ShoppingCartController {

    def shoppingCartService
	
	def view(){
		def cart = shoppingCartItems()
		[cart:cart]
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
			println("pN"+params.productNumber)
			println("pI"+item.productInfo['productNumber'])
			println(item.productInfo['productNumber'].toString() == params.productNumber.toString())
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
}
package shoppingsolutionproject

import java.util.List;

class ShoppingCartController {

    def shoppingCartService
	
	def addToCart(){
		def product = Item.findBySku(params.sku)
		shoppingCartService.addToShoppingCart(product)
		render(text:'',contentType:'text/plain')
	}
	
	def itemInCart(){
		def cartHasItem = false
		def product = Item.findBySku(params.sku)
		def cart = shoppingCartItems()
		cart.each() { item ->
			if (item.productInfo.sku == params.sku){
				cartHasItem = true
			} 
		}
		render(cartHasItem)
	}
	
	def view(){
		def cart = shoppingCartItems()
		[cart:cart]
	}

	def removeFromCart(){
		def product = Item.findBySku(params.sku)
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
		def product = Item.findBySku(params.sku)
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
		def newPrice = shoppingCartService.getQuantity(product)*product.price
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
package shoppingsolutionproject

import java.util.List;

import grails.transaction.Transactional

@Transactional
class CartService {
	
	def shoppingCartService

    def shoppingCartItems() {
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
	
	def shoppingCart(){
		def cart = []
		def items = shoppingCartService.getItems()
		
		items?.sort { a, b -> a.id <=> b.id }.each { item ->
			def itemInfo = ['item': item,
					'qty':shoppingCartService.getQuantity(item)]

		cart.add(itemInfo)
		return cart
		}
	}
	
	def subtotal(List cart) {
		def subTotal = 0
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
		}
		return subTotal
	}
	
	def shippingCost(){
		def shippingCost=0
		def cart = shoppingCartItems();
		if (cart.isEmpty()){
			return 0.00
		}
		else{
			cart.each(){item ->
				shippingCost += item.productInfo['shippingCost']*item.qty ?: 0.00
			}
		}
		return shippingCost
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
}
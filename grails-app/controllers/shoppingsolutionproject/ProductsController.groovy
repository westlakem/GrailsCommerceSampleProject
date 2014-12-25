package shoppingsolutionproject

import java.util.List;

class ProductsController {

    def shoppingCartService
	
	def index(){
		def products = Item.all
		[products:products]
	}
}

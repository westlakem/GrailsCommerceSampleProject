package shoppingsolutionproject

import java.util.List;

class ProductsController {

    def shoppingCartService
	
	def list(){
		def searchParams = params.searchParam
		def products
		println(searchParams)
		if(params.searchParam){
			if (searchParams.isInteger()){
				products = Item.findAllByProductNumberLike("%${searchParams}%")			
			}
			else{
				products = Item.findAllByNameIlikeOrDescriptionIlike("%${searchParams}%","%${searchParams}%")
			}			
		}
		else{
			products=Item.all
		}
		[products:products]
	}
}

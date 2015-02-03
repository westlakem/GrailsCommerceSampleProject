package shoppingsolutionproject

import java.util.List;

class ProductsController {

    def shoppingCartService
	
	def list(){
		def searchParams = params.searchParam
		def products
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
	
	def listCategories(){
		def categoryMap = [:]
		def firstCategories = Category.findAllByParentCategoryIsNull()
		firstCategories.each(){category ->
			categoryMap << [(category.name): getChildrenCategories(category)]
		}
		return (categoryMap)
	}
	
	private getChildrenCategories(category){
		Category.findAllByParentCategory(category).each(){childCategory ->
			return [(childCategory.name):getChildrenCategories(childCategory)]
		}
		
	}
}

package pages.category

import geb.Page

class AddCategoryPage extends Page {
	static url="category/create"
	
	static at= {
		title ==~ /Create Category/
	}
	
	static content={
		category {$("input", name: 'category')}
		submitCategory {$("input", id: 'create')}
	} 
	
	def addCategory(categoryName){
		category = categoryName
	}
	
	
}
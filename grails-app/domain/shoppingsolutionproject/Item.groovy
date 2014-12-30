package shoppingsolutionproject

class Item extends com.metasieve.shoppingcart.Shoppable{

	int productNumber
	String name
	String description
	Double shippingCost = null
	String url
	Double retailPrice
	Double salePrice = null
	Category category
	
	static constraints = {
		shoppingItem display:false
		productNumber min: 0, unique: true
		name blank:false
		description blank:false, widget:'textarea'
		retailPrice min:0.00d
		shippingCost nullable:true
		url blank:false, unique: true
		salePrice nullable:true, blank:true
		category nullable:false
	}
}

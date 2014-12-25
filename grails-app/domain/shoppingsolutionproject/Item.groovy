package shoppingsolutionproject

class Item {

	int squNumber
	String name
	String description
	Double shippingCost = null
	String url
	Double retailPrice
	Double salePrice = null
	Category category
	
	static constraints = {
		squNumber min: 0, unique: true
		name blank:false, minSize:5
		description blank:false, minSize:30, widget:'textarea'
		retailPrice min:0.00d
		shippingCost nullable:true
		url blank:false
		salePrice nullable:true, blank:true
		category nullable:false
	}
}

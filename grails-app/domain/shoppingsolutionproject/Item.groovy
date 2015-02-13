package shoppingsolutionproject

class Item extends com.metasieve.shoppingcart.Shoppable{

	Boolean tangible
	Integer productNumber
	Integer tic
	String name
	String description
	String url
	Boolean shippable = true
	Double shippingCost = null
	Double retailPrice
	Double salePrice = null
	String primaryImage
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
		primaryImage display:false, nullable:true
	}
}

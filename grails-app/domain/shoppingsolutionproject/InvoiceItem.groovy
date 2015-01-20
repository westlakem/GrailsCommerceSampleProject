package shoppingsolutionproject

class InvoiceItem {
	
	Integer productNumber 
	String name
	String description
	Double price
	Integer qty

    static constraints = {
    }
	
	@Override
	String toString(){
		"${productNumber}: ${name}: ${description}"
	}
}

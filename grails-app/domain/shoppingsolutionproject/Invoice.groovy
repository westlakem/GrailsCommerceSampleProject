package shoppingsolutionproject

class Invoice {
	
	String name
	Double shippingCost
	Double subTotal
	Double tax
	Integer confirmationNumber
	Boolean fulfilled
	
	Double getTotalCost(){(shippingCost + subTotal + tax).round(2)}
	
	static transients = ['totalCost']
	
	static hasMany = [invoiceItems : InvoiceItem]
}
package shoppingsolutionproject

class Invoice {
	
	String name
	Double shippingCost
	Double subtotal
	Double tax
	Integer confirmationNumber
	Boolean fulfilled
	Boolean paid
	
	Double getTotal(){(shippingCost + subtotal + tax).round(2)}
	
	static transients = ['totalCost']
	
	static hasOne = [shippingAddress : Address, billingAddress : Address]
	
	static hasMany = [invoiceItems : InvoiceItem]
	
	static constraints = {
		confirmationNumber nullable:true
	}
}
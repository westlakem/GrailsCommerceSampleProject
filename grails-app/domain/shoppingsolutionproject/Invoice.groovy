package shoppingsolutionproject

class Invoice {
	
	String name
	Double shippingCost
	Double subtotal
	Double tax
	String paymentConfirmation
	Boolean fulfilled
	Boolean paid
	Address shippingAddress
	Address billingAddress
	Customer customer
	
	Double getTotal(){(shippingCost + subtotal + tax).round(2)}
	
	static transients = ['totalCost']
	
	static hasMany = [invoiceItems : InvoiceItem]
	
	static constraints = {
		paymentConfirmation nullable:true
		customer nullable:true
	}
}
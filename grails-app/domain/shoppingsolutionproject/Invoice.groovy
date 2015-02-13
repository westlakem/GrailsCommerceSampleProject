package shoppingsolutionproject

class Invoice {
	
	String name
	Double shippingCost
	Double subtotal
	Double tax
	String paymentTrasactionId
	Boolean fulfilled
	Boolean paid
	Address shippingAddress
	Address billingAddress
	Customer customer
	
	Double getTotal(){(shippingCost + subtotal + tax).round(2)}
	
	static transients = ['totalCost']
	
	static hasMany = [invoiceItems : InvoiceItem]
	
	static constraints = {
		paymentTrasactionId nullable:true
		customer nullable:true
		tax nullable:true
	}
}
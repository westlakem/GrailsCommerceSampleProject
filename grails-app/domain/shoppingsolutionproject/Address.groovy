package shoppingsolutionproject

class Address {
	
	String address1
	String address2
	String city
	String state
	Integer zipCode

    static constraints = {
		address2 nullable:true
    }
	
	static belongsTo = [shippingAddress: ShippingAddress, billingAddress: BillingAddress]
}

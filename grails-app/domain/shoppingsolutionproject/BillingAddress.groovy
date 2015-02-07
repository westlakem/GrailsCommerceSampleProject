package shoppingsolutionproject

class BillingAddress{
	
	Address address	
	static belongsTo = [customer: Customer]

    static constraints = {
    }
}

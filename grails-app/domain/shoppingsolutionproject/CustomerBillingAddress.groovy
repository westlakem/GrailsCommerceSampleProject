package shoppingsolutionproject

class CustomerBillingAddress{
	
	Address address	
	static belongsTo = [customer: Customer]

    static constraints = {
    }
}

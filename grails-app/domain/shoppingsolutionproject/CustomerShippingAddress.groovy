package shoppingsolutionproject

class CustomerShippingAddress{
	
	Address address
	
	static belongsTo = [customer: Customer]

    static constraints = {
    }
}

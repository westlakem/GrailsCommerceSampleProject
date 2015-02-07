package shoppingsolutionproject

class ShippingAddress{
	
	Address address
	
	static belongsTo = [customer: Customer]

    static constraints = {
    }
}

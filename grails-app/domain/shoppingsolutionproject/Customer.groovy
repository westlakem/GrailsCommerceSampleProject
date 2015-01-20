package shoppingsolutionproject

class Customer  {
	
//	static belongsTo = [user : User]
	static hasMany = [billingAddresses: Address, shippingAddresses: Address, orders: Invoice]

    static constraints = {
    }
}

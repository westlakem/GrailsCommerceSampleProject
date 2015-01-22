package shoppingsolutionproject

class Customer  {
	
//	static belongsTo = [user : User]
	static hasMany = [billingAddresses: Address, shippingAddresses: Address, invoices: Invoice]

    static constraints = {
    }
}

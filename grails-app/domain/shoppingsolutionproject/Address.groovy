package shoppingsolutionproject

class Address {
	
	String address1
	String address2
	String city
	String state
	Integer zipCode
	
	static belongsTo = [customer: Customer]

    static constraints = {
		address2 nullable:true
		customer nullable:true
    }
}

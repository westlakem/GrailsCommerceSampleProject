package shoppingsolutionproject

import org.hibernate.validator.constraints.Email

class Customer  {
	
	String phoneNumber
	String emailAddress
	User user
	static hasMany = [billingAddresses: Address, shippingAddresses: Address, invoices: Invoice]

    static constraints = {
		emailAddress email:true
		phoneNumber matches: "[0-9]{3}-[0-9]d{3}-[0-9]{4}"
    }
}

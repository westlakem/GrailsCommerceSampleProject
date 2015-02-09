package shoppingsolutionproject

import org.hibernate.validator.constraints.Email

class Customer  {
	String firstName
	String lastName
	String phoneNumber
	String emailAddress
	User user
	static hasMany = [billingAddresses: CustomerBillingAddress, shippingAddresses: CustomerShippingAddress, invoices: Invoice]

    static constraints = {
		emailAddress email:true
		phoneNumber matches: /[0-9]{10}/
    }
}

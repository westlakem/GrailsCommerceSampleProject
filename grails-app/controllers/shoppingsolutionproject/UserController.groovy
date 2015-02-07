package shoppingsolutionproject

class UserController {
	
	def taxService

    def scaffold = User
	
	def registerCustomer(){
		
	}
	
	def createCustomerRecord(){
		def shippingAddress
		def billingAddress
		def validUser = true
		if(!validPassword()){
			validUser = false
			flash.message = "Passwords Must Match"
		}
		if(User.findByUsername(params.username)){
			validUser = false
			flash.message = "Username Already In Use"
		}
		if(validUser){
			shippingAddress = new ShippingAddress(
					address1: params.shippingAddress1, address2: params.shippingAddress2, 
					city: params.shippingCity, state: params.shippingState, zipCode: params.shippingZipCode)
			billingAddress = new BillingAddress(
					address1: params.billingAddress1, address2: params.billingAddress2, 
					city: params.billingCity, state: params.billingState, zipCode: params.billingZipCode)
			def addressValidationErrors = taxService.addressLookup(billingAddress)
			def shippingValidationErrors = taxService.addressLookup(shippingAddress)
			if(addressValidationErrors){
				validUser = false
				flash.message = "Invalid Billing Address Entered"
			}
			if(shippingValidationErrors && !addressValidationErrors){
				validUser = false
				flash.message = "Invalid Shipping Address Entered"
			}
					
		}		
		if(validUser){
			def user = new User(username: params.username, password: params.password)
			user.save(flush: true)
			def customer = new Customer(firstName: params.firstName, lastName: params.lastName,
				user: user, emailAddress: params.emailAddress, phoneNumber:params.phoneNumber)
			customer.addToBillingAddresses(billingAddress)
			customer.addToShippingAddresses(shippingAddress)
			if (customer.save(flush: true)){
				render(view:'registrationComplete')
			}
			else{
				validUser = false
				flash.message = user.errors.allErrors
			}			
		}
		if(!validUser){
			redirect(action:'registerCustomer', params:params)
		}
	}
	def validPassword(){
		params.password == params.confirmPassword
	}
}

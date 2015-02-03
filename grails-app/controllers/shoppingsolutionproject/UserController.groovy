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
			flash.message = "Username Already In Use"
		}
		if(validUser){
			shippingAddress = new Address(
					params.shippingAddress1, params.shippingAddress2, params.shippingCity, params.shippingState, params.shippingZipCode)
			billingAddress = new Address(
					params.billingAddress1, params.billingAddress2, params.billingCity, params.billingState, params.billingZipCode)
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
			def customer = new Customer(user: user, emailAddress: params.emailAddress, phoneNumber:params.phoneNumber,
					shippingAddress: shippingAddress, billingAddress:billingAddress)
			if (customer.save()){
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

package shoppingsolutionproject

import org.junit.internal.runners.statements.FailOnTimeout;

class UserController {
	
	def taxService

    def scaffold = User
	
	def registerCustomer(){
		
	}
	
	def createCustomerRecord(){
		def sAddress
		def bAddress
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
			sAddress = Address.findOrCreateByAddress1AndAddress2AndCityAndStateAndZipCode(
					params.shippingAddress1, params.shippingAddress2, 
					params.shippingCity, params.shippingState, params.shippingZipCode)
			bAddress = Address.findOrCreateByAddress1AndAddress2AndCityAndStateAndZipCode(
					params.billingAddress1, params.billingAddress2, 
					params.billingCity, params.billingState, params.billingZipCode)
			def addressValidationErrors = taxService.addressLookup(bAddress)
			def shippingValidationErrors = taxService.addressLookup(sAddress)
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
			user.save(flush: true, failOnError: true)
			def customer = new Customer(firstName: params.firstName, lastName: params.lastName,
				user: user, emailAddress: params.emailAddress, phoneNumber:params.phoneNumber)
			bAddress.save(flush:true)
			sAddress.save(flush:true)
			def billingAddress = new CustomerBillingAddress(address: bAddress)
			def shippingAddress = new CustomerShippingAddress(address: sAddress)
			customer.addToBillingAddresses(billingAddress)
			customer.addToShippingAddresses(shippingAddress)
			if (customer.save(flush: true)){
				render(view:'registrationComplete')
			}
//			else{
//				validUser = false
//				flash.message = user.errors.allErrors
//				user.delete(flush: true)
//			}			
		}
		if(!validUser){
			redirect(action:'registerCustomer', params:params)
		}
	}
	def validPassword(){
		params.password == params.confirmPassword
	}
}

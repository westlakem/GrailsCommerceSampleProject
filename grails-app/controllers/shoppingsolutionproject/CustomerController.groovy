package shoppingsolutionproject

class CustomerController {
	
	def taxService
	def springSecurityService

    def addAddress(){
		def user = springSecurityService.getCurrentUser()
		def customer = Customer.findByUser(user)
		if(!customer){
			response.sendError(500, "unauthorized")
		}
		else{
			def address = Address.findOrCreateByAddress1AndAddress2AndCityAndStateAndZipCode(
					params.address1, params.address2, params.city, params.state, params.zip)
			def addressValidationErrors = taxService.addressLookup(address)
			if (!(addressValidationErrors)){
				address.save(flush:true)			
				switch(params.addressType){
				case 'billing':
					def billingAddress = new CustomerBillingAddress(address: address)
					customer.addToBillingAddresses(billingAddress)					
				break
				case 'shipping':
					def shippingAddress = new CustomerShippingAddress(address: address)
					customer.addToShippingAddresses(shippingAddress)
				break					
				}
				customer.save(flush: true,failOnError: true)
			}			
		}
		redirect(uri: request.getHeader('referer'))
	}
	
	def removeAddress(){
		def user = springSecurityService.getCurrentUser()
		def customer = Customer.findByUser(user)
		if(!customer){
			response.sendError(500, "unauthorized")
		}
		else{
			def address = Address.findByAddress1AndAddress2AndCityAndStateAndZipCode(
				params.address1, params.address2, params.city, params.state, params.zip)
			switch(params.addressType){
				case 'billing':
					def billingAddress = customer.billingAddresses.findByAddress(address)
					customer.removeFromBillingAddresses(billingAddress)
				break
				case 'shipping':
					def shippingAddress = customer.shippingAddresses.findByAddress(address)
					customer.removeFromShippingAddresses(shippingAddress)
				break
			}
			customer.save(failOnError: true)
		}
	}
}


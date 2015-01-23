package shoppingsolutionproject

import com.twocheckout.model.Authorization
import com.twocheckout.Twocheckout
import com.twocheckout.TwocheckoutCharge
import net.authorize.sim.Fingerprint
import grails.transaction.Transactional

@Transactional
class TwoCheckoutService {
	
	def generateToken(){
		
	}
	
	def processPayment(invoice){

		def message
		
		Twocheckout.privatekey = grailsApplication.config.shoppingService.twoCheckout.privateKey;
		Twocheckout.mode = grailsApplication.config.shoppingService.twoCheckout.environment;
		
		try {
			HashMap billing = new HashMap();
			billing.put("name", invoice.name);
			billing.put("addrLine1", invoice.billingAddress.address1);
			billing.put("city", invoice.billingAddress.city);
			billing.put("state", invoice.billingAddress.state);
			billing.put("country", "USA");
			billing.put("zipCode", invoice.billingAddress.zipCode);
			billing.put("email", "tester@2co.com");//TODO: add this from user
			billing.put("phoneNumber", "555-555-5555");//TODO: add this from user
		
			HashMap request = new HashMap();
			request.put("sellerId", grailsApplication.config.shoppingService.twoCheckout.sellerId);
			request.put("merchantOrderId", invoice.id);
			request.put("token", params.token);
			request.put("currency", "USD");
			request.put("total", invoice.total);
			request.put("billingAddr", billing);
		
			Authorization response = TwocheckoutCharge.authorize(request);
			invoice.confirmationNumber = response.getOrderNumber()
			invoice.paid = true
			invoice.save(flush: true)
			//TODO: add order to customer and save
			
			message = 'SUCCESS'
			
		} catch (Exception e) {
			message = e.toString();
		}
		[message: message]
	}

    def serviceMethod() {

    }
}

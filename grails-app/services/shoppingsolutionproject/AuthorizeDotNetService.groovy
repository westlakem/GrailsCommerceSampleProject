package shoppingsolutionproject

import grails.transaction.Transactional
import net.authorize.sim.Fingerprint

@Transactional
class AuthorizeDotNetService {
	
	def cartService

    def authorizeDotNetCheckout(cart){
		def subTotal
		def shippingCost
		(subTotal, shippingCost) = getCartSubtotal(cart)
		def cartItems = compileArrayOfCartItem(cart)
		def taxAmmt = getTaxAmmount(cartItems).round(2)
		def totalPrice = (subTotal + shippingCost + taxAmmt).toString()
		
		Fingerprint fingerprint = Fingerprint.createFingerprint(
		  grailsApplication.config.shoppingService.authorizeDotNet.apiLoginID,
		  grailsApplication.config.shoppingService.authorizeDotNet.transactionKey,
		  1234567890, // random sequence used for creating the fingerprint
		  totalPrice);
   
		long x_fp_sequence = fingerprint.getSequence();
		long x_fp_timestamp = fingerprint.getTimeStamp(	);
		String x_fp_hash = fingerprint.getFingerprintHash();
		
		[fingerprint: fingerprint, totalPrice: totalPrice]
	}
}

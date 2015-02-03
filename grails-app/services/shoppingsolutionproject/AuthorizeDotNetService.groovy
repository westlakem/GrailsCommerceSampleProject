package shoppingsolutionproject

import grails.transaction.Transactional
import net.authorize.sim.Fingerprint

@Transactional
class AuthorizeDotNetService {
	
	def cartService
	
	def apiLoginID
	def transactionKey
	def responseUrl
	def md5Hash
	def randomGenerator

    def generateToken(invoice){
		String apiLoginId = apiLoginID;
		String transactionKey = transactionKey;
		String relayResponseUrl = responseUrl;

		Fingerprint fingerprint = Fingerprint.createFingerprint(
          apiLoginId,
          transactionKey,
          randomGenerator.nextInt(),  // Random sequence used for creating the fingerprint
          invoice.total.toString());

	  	long x_fp_sequence = fingerprint.getSequence();
		long x_fp_timestamp = fingerprint.getTimeStamp();
		String x_fp_hash = fingerprint.getFingerprintHash(); 
		
		return fingerprint
	}
	
	def authorizePayment(invoice, params){
		def authResponse
		def success = false
		net.authorize.sim.Result result = net.authorize.sim.Result.createResult(apiLoginID, md5Hash, params);
		if(result == null){
			authResponse['responseReasonText'] = 'No Result returned'
		}
		else{
			authResponse['responseCode'] = result.getResponseCode().getCode()
			authResponse['responseReasonCode'] = result.getReasonResponseCode().getResponseReasonCode()
			authResponse['responseReasonText'] = result.getResponseMap().get(ResponseField.RESPONSE_REASON_TEXT.getFieldName())
			if(result.isApproved())
			{
				authResponse['transactionId'] = result.getResponseMap().get(ResponseField.TRANSACTION_ID.getFieldName())
				success = true
			}
		}
		return [success, authResponse['responseReasonText']]
	}
	
	def capturePayment(invoice, params){
		
	} 
}
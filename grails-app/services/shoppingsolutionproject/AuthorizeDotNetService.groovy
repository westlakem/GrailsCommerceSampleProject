package shoppingsolutionproject

import grails.transaction.Transactional
import grails.plugins.rest.client.RestBuilder
import net.authorize.sim.Fingerprint

/*<%@ page import="java.math.BigDecimal" %>
<%@ page import="java.util.Map" %>
<%@ page import="net.authorize.Environment" %>
<%@ page import="net.authorize.Merchant" %>
<%@ page import="net.authorize.TransactionType" %>
<%@ page import="net.authorize.aim.Result" %>
<%@ page import="net.authorize.aim.Transaction" %>
<%@ page import="net.authorize.data.*" %>
<%@ page import="net.authorize.data.creditcard.*" %>
<%
	 String apiLoginID = "YOUR_API_LOGIN_ID";
	 String transactionKey = "YOUR_TRANSACTION_KEY";
	 Merchant merchant = Merchant.createMerchant(Environment.SANDBOX, apiLoginID,
transactionKey);

	 // Create credit card
	 CreditCard creditCard = CreditCard.createCreditCard();
	 creditCard.setCreditCardNumber("4111 1111 1111 1111");
	 creditCard.setExpirationMonth("12");
	 creditCard.setExpirationYear("2016");

	 // Create transaction
	 Transaction authCaptureTransaction = merchant.createAIMTransaction(
TransactionType.AUTH_CAPTURE, new BigDecimal(1.99));
	 authCaptureTransaction.setCreditCard(creditCard);
	 Result<Transaction> result = (Result<Transaction>)merchant.postTransaction(
authCaptureTransaction);

	 if (result.isApproved())
	 {
		  out.println("Approved!</br>");
		  out.println("Transaction Id: " + result.getTarget().getTransactionId());
	 } else if (result.isDeclined()) {
		  out.println("Declined.</br>");
		  out.println(result.getReasonResponseCode() + " : " + result.getResponseText());
	 } else {
		  out.println("Error.</br>");
		  out.println(result.getReasonResponseCode() + " : " + result.getResponseText());
	 }
%>*/

@Transactional
class AuthorizeDotNetService {
	
	def cartService
	def grailsApplication
	def apiLoginID
	def transactionKey
	def responseUrl
	def md5Hash
	def randomGenerator

    def generateToken(invoice){
		def randomSeq = randomGenerator.nextInt(99999999)
		
		Fingerprint fingerprint = Fingerprint.createFingerprint(
          apiLoginID,
          transactionKey,
          randomSeq,  // Random sequence used for creating the fingerprint
          invoice.total.toString());

		println(apiLoginID)
		println(transactionKey)
		println(randomSeq)
		println (invoice.total.toString())
		println(fingerprint.fingerprintHash)
		return fingerprint
	}
	
	def authorizeAndCapturePayment(request){
		def authResponse = [:]
		def success = false
		net.authorize.sim.Result result = net.authorize.sim.Result.createResult(apiLoginID, md5Hash.toString(), request.getParameterMap());
		if(result == null){
			authResponse['responseReasonText'] = 'No Result returned'
		}
		else{
			authResponse['responseCode'] = result.getResponseCode().getCode()
			authResponse['responseReasonCode'] = result.getReasonResponseCode().getResponseReasonCode()
			authResponse['responseReasonText'] = result.getResponseMap().get('x_response_reason_text')
			if(result.isApproved())
			{
				authResponse['transactionId'] = result.getResponseMap().get('x_trans_id')
				authResponse['invoiceId'] = result.getResponseMap().get('x_invoice_num')
				authResponse['paymentAmount'] = result.getResponseMap().get('x_amount')
				success = true
			}
		}
		println(authResponse['responseReasonCode'])
		return [success, authResponse, authResponse['responseReasonText']]
	} 
}
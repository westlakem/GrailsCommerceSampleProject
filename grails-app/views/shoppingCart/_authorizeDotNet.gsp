<form hidden="true" id='myCCForm' name='myCCForm' action='https://test.authorize.net/gateway/transact.dll'>
<input name='x_card_num'/>
<input name='x_exp_date'/>
<input name='x_amount' value = "${invoice.total}"/>
<input name='x_invoice_num' value='<%=System.currentTimeMillis()%>' /> 
<input name='x_relay_url' value='${grailsApplication.config.shoppingService.authorizeDotNet.responseUrl}' /> 
<input name='x_login' value='${grailsApplication.config.shoppingService.authorizeDotNet.apiLoginID}' /> 
<input name='x_fp_sequence' value='${paymentToken.getSequence()}' /> 
<input name='x_fp_timestamp' value='${paymentToken.getTimeStamp()}' /> 
<input name='x_fp_hash' value='${paymentToken.getFingerprintHash()}' /> 
<input name='x_version' value='3.1' /> 
<input name='x_method' value='CC' /> 
<input name='x_type' value='AUTH_ONLY' /> 
<input name='x_test_request' value='FALSE' /> 
</form>

<script type="text/javascript">
$(function() {    
    $("#submitPayment").click(function(){
		$("input[name='x_card_num']").val($('#ccNo').val())
		$("input[name='x_exp_date']").val($('#expMonth').val()+$('#expYear').val())
		$('#myCCForm').submit();
    })
})
</script>
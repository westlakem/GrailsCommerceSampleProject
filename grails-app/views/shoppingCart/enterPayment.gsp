<meta name="layout" content="main">
<div class="error">
	<g:message code="${flash.message}"/>
</div>
<div id="paymentInfo"></div>
<div id="creditCardInfo">
  <div class= 'table'>
	  <div class="row">
	    <div class="cell">Card Number</div>
	    <div class="cell"><input id="ccNo" type="text" value="4000000000000002" autocomplete="off" required size="16" maxlength="16" /></div>
	  </div>
	  <div class="row">
	      <div class="cell">Expiration Date <br>(MM/YYYY)</div>
	      <div class="cell"><input value = "10" id="expMonth" type="text" size="2" maxlength="2" required />
	    <span> / </span>
	    <input id="expYear" type="text" size="4" maxlength="4" value="2016" required /></div>
	  </div>
	  <div class = "row">
	      <div class="cell">CVC</div>
	      <div class="cell"><input value="776" id="cvv" type="text" value="" autocomplete="off" size="3" maxlength = "3" required /></div>
	  </div>
	  <input type="hidden" name="invoiceNumber" value="${invoice.id}">
  </div>
</div>
<button type="button" id="submitPayment" value="Submit Payment">Submit Payment</button>

${grailsApplication.config.shoppingService.paymentProvider}
<g:render template="${grailsApplication.config.shoppingService.paymentProvider}"/>

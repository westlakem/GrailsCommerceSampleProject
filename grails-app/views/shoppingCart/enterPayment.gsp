<g:form name="myCCForm" action="authorize2CoCheckout">
  <input name="token" type="hidden" value="" />
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
  </div>
  <g:submitButton name="sub" value="Submit Payment" />
</g:form>

<script>
  // Called when token created successfully.
  var successCallback = function(data) {
    var myForm = document.getElementById('myCCForm');

    // Set the token as the value for the token input
    myForm.token.value = data.response.token.token;

    // IMPORTANT: Here we call `submit()` on the form element directly instead of using jQuery to prevent and infinite token request loop.
    myForm.submit();
  };

  // Called when token creation fails.
  var errorCallback = function(data) {
    // Retry the token request if ajax call fails
    if (data.errorCode === 200) {
       // This error code indicates that the ajax call failed. We recommend that you retry the token request.
    } else {
      alert(data.errorMsg);
    }
  };

  var tokenRequest = function() {
    // Setup token request arguments
    var args = {
      sellerId: '${grailsApplication.config.shoppingService.twoCheckout.sellerId}',
      publishableKey: '${grailsApplication.config.shoppingService.twoCheckout.publicKey}',
      ccNo: $("#ccNo").val(),
      cvv: $("#cvv").val(),
      expMonth: $("#expMonth").val(),
      expYear: $("#expYear").val()
    };

    // Make the token request
    TCO.requestToken(successCallback, errorCallback, args);
  };

  $(function() {
    // Pull in the public encryption key for our environment
    TCO.loadPubKey('${grailsApplication.config.shoppingService.twoCheckout.environment}');

    $("#myCCForm").submit(function(e) {
      // Call our token request function
      tokenRequest();

      // Prevent form from submitting
      return false;
    });
  });

</script>
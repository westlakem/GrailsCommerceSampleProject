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
    
    $("#submitPayment").click(function(){
		$("#paymentInfo").html(function(){
			var ccInfo = $("#creditCardInfo").html()
			return "<g:form name='myCCForm' action='paymentConfirmation'> \
			  <input name='token' type='hidden' value='' />" + ccInfo	  
		})
	})
	
	tokenRequest();
  });
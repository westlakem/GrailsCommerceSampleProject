<meta name="layout" content="main">
<div class="error">
	<g:message code="${flash.message}"/>
</div>
<div>
	<h2>Register/Login</h2>
	<p> Existing users can login for speedy checkout</p>
	<g:link controller='shoppingCart' action='checkoutAsAuthenticated'>
		<button type="button">Login To Continue</button>
	</g:link>
	<p> Don't have an account?</p>
	<g:link controller='user' action='registerCustomer' target="_blank">
		<button type="button">Register Now!</button>
	</g:link>
</div>
<div>
	<p> Don't want an account for speedy checkout?</p>
	<g:link controller='shoppingCart' actiion='checkoutAsGuest'>
		<button type="button">Checkout as Guest</button>
	</g:link>
</div>
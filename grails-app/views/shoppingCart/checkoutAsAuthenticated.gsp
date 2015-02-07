<meta name="layout" content="main">
<h1>Checkout</h1>
<div class="error">
	<g:message code="${flash.message}"/>
</div>
<g:form controller="shoppingCart" action="review">
	<h2>Billing Address</h2>
		<g:select name="billingAddress" from="${customer.billingAddresses}" 
			optionValue="address1" optionKey="id" noSelection="${['null':'Billing Address']}"/>
	<h2>Shipping Address</h2>
		<g:select name="shippingAddress" from="${customer.shippingAddresses}" 
			optionValue="address1" optionKey="id" noSelection="${['null':'Shipping Address']}"/>
	<div>
	<g:submitButton name="submit" value="Continue to Summary"/>
	</div>
</g:form>
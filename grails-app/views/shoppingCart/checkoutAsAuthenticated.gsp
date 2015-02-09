<meta name="layout" content="main">
<h1>Checkout</h1>
<div class="error">
	<g:message code="${flash.message}"/>
</div>
<g:form controller="shoppingCart" action="review">
	<h2>Billing Address</h2>
		<div>
			<g:select name="billingAddress" from="${customer.billingAddresses.address}" 
				optionValue="address1" optionKey="id" noSelection="${['null':'Billing Address']}"/>
			<button id="deleteBillingAddress" type="button">Delete Address</button>
		</div>
		<div>
			<button id="addBillingAddress" type="button">Add Address</button>
		</div>
	<h2>Shipping Address</h2>
		<div>
			<g:select name="shippingAddress" from="${customer.shippingAddresses.address}" 
				optionValue="address1" optionKey="id" noSelection="${['null':'Shipping Address']}"/>
			<button id="deleteShippingAddress" type="button">Delete Address</button>
		</div>
		<div>
			<button id="addShippingAddress" type="button">Add Address</button>
		</div>
	<div>
	<g:submitButton name="submit" value="Continue to Summary"/>
	</div>
</g:form>
<div id="newBillingAddress" hidden="true">
	<g:form controller="customer" action="addAddress">
		<g:textField name="addressType" hidden="true" value="billing"/>
		<g:render template="/genericTemplates/newAddress"></g:render>
		<g:submitButton name="addBillingAddress" value="Submit New Address"/>
	</g:form>
</div>
<div id="newShippingAddress" hidden="true">
	<g:form controller="customer" action="addAddress">
		<g:textField name="addressType" hidden="true" value="billing"/>
		<g:render template="/genericTemplates/newAddress"></g:render>
		<g:submitButton name="addShippingAddress" value="Submit New Address"/>
	</g:form>
</div>
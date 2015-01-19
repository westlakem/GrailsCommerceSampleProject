<div>
	<g:if test="${grailsApplication.config.shoppingService.paymentProvider=='authorize.net'}">	
		<g:form controller="shoppingCart" action="authorizeDotNetCheckout">
			<g:textField name="name" value="${name}" readonly/>
			<g:textField name="address1" value="${shippingAddress.address1}" readonly/>
			<g:textField name="address2" value="${shippingAddress.address2}" readonly/>
			<g:textField name="city" value="${shippingAddress.city}" readonly/>
			<g:textField name="state" value="${shippingAddress.state}" readonly/>
			<g:textField name="zip" value="${shippingAddress.zip}" readonly/>	
			<g:submitButton name="payNow" value="Pay Now!"/>
		</g:form>
	</g:if>
	<g:elseif test="${grailsApplication.config.shoppingService.paymentProvider=='2Checkout'}">
		<g:link controller="shoppingCart" action="checkout">
			<button>Checkout</button>
		</g:link>
	</g:elseif>
	<g:else>
		<div>Please setup the payment configuration for a supported payment provider</div>
	</g:else>
</div>	
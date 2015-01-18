<g:if test="${cart!=[]}">
	<div id = "cartButtons" class = "cart_buttons">
		<g:link name = "emptyCart" class ="cart_buttons_img empty_cart_link" controller="shoppingCart" action="emptyCart"><input type="button" class="button empty_cart" value="Empty Cart"/></g:link>
		<g:if test="${grailsApplication.config.shoppingService.paymentProvider=='authorize.net'}">
			
			<g:link class ="cart_buttons_img" controller="shoppingCart" action="checkoutCart"><g:img uri="https://www.paypalobjects.com/webstatic/en_US/btn/btn_checkout_pp_142x27.png "/></g:link>
			<g:link class ="cart_buttons_img" controller="shoppingCart" action="checkoutCart"><g:img uri="https://www.paypalobjects.com/webstatic/en_US/btn/btn_paynow_cc_144x47.png"/></g:link>
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
</g:if>
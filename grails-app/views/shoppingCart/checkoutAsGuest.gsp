<meta name="layout" content="main">
<div class="error">
	<g:message code="${flash.message}"/>
</div>
<div>
	<g:form contoller="shoppingCart" action="review">
	<h2>Personal Information</h2>
	<h2>Billing Information</h2>
	<div class = "table">
		<div class="row">
			<div class="cell">
				First Name
			</div>
			<div class="cell">
				<g:textField name="firstName" />
			</div>
		</div>
		<div class="row">
			<div class="cell">
				Last Name
			</div>
			<div class="cell">
				<g:textField name="lastName" />
			</div>
		</div>
		<div class="row">
			<div class="cell">
				Phone
			</div>
			<div class="cell">
				<g:textField name="phone" />
			</div>
		</div>
		<div class="row">
			<div class="cell">
				Email
			</div>
			<div class="cell">
				<g:textField name="emailAddress" />
			</div>
		</div>
		<div class="row">
			<div class="cell">
				Address 1
			</div>
			<div class="cell">
				<g:textField name="address1" />
			</div>
		</div>
		<div class="row">
			<div class="cell">
				Address 2
			</div>
			<div class="cell">
				<g:textField name="address2" />
			</div>
		</div>
		<div class="row">
			<div class="cell">
				City
			</div>
			<div class="cell">
				<g:textField name="city" />
			</div>
		</div>
		<div class="row">
			<div class="cell">
				State
			</div>
			<div class="cell">
				<g:textField name="state" />
			</div>
		</div>
		<div class="row">
			<div class="cell">
				Zip
			</div>
			<div class="cell">
				<g:textField name="zip" />
			</div>
		</div>
	</div>
	<h2>Shipping Information</h2>
	<button type="button" id="useBillingInfo">Update from Billing information</button>
	<div class = "table">
		<div class="row">
			<div class="cell">
				First Name
			</div>
			<div class="cell">
				<g:textField name="shippingFirstName" />
			</div>
		</div>
		<div class="row">
			<div class="cell">
				Last Name
			</div>
			<div class="cell">
				<g:textField name="shippingLastName" />
			</div>
		</div>
		<div class="row">
			<div class="cell">
				Address 1
			</div>
			<div class="cell">
				<g:textField name="shippingAddress1" />
			</div>
		</div>
		<div class="row">
			<div class="cell">
				Address 2
			</div>
			<div class="cell">
				<g:textField name="shippingAddress2" />
			</div>
		</div>
		<div class="row">
			<div class="cell">
				City
			</div>
			<div class="cell">
				<g:textField name="shippingCity" />
			</div>
		</div>
		<div class="row">
			<div class="cell">
				State
			</div>
			<div class="cell">
				<g:textField name="shippingState" />
			</div>
		</div>
		<div class="row">
			<div class="cell">
				Zip
			</div>
			<div class="cell">
				<g:textField name="shippingZip" />
			</div>
		</div>
	</div>
		<g:submitButton name="purchaseSummary" value = "Continue to Summary"/>
	</g:form>
</div>
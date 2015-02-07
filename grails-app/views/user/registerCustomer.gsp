<meta name="layout" content="main">
<div class="error">
	<g:message code="${flash.message}"/>
</div>
<h1>Registration</h1>
<g:form action="createCustomerRecord">
	<h2>UserInfo</h2>
	<div class='table'>
		<div class='row'>
			<div class='cell'>
				First Name:
			</div>
			<div class='cell'>
				<g:textField name="firstName" value="${params.firstName}" />
			</div>
		</div>
		<div class='row'>
			<div class='cell'>
				Last Name:
			</div>
			<div class='cell'>
				<g:textField name="lastName" value="${params.lastName}"/>
			</div>
		</div>
		<div class='row'>
			<div class='cell'>
				Username:
			</div>
			<div class='cell'>
				<g:textField name="username" value="${params.username}"/>
			</div>
		</div>
		<div class='row'>
			<div class='cell'>
				Password:
			</div>
			<div class='cell'>
				<g:passwordField name="password"/>
			</div>
		</div>
		<div class='row'>
			<div class='cell'>
				Confirm Password:
			</div>
			<div class='cell'>
				<g:passwordField name="confirmPassword"/>
			</div>
		</div>
		<div class='row'>
			<div class='cell'>
				Email Address:
			</div>
			<div class='cell'>
				<g:textField name="emailAddress" value="${params.emailAddress}"/>
			</div>
		</div>
		<div class='row'>
			<div class='cell'>
				Phone Number:
			</div>
			<div class='cell'>
				<g:textField name="phoneNumber" value="${params.phoneNumber}"/>
			</div>
		</div>
		<h2>Billing Address</h2>
		<div class='row'>
			<div class='cell'>
				Address 1:
			</div>
			<div class='cell'>
				<g:textField name="billingAddress1" value="${params.billingAddress1}"/>
			</div>
		</div>
		<div class='row'>
			<div class='cell'>
				Address 2:
			</div>
			<div class='cell'>
				<g:textField name="billingAddress2" value="${params.billingAddress2}"/>
			</div>
		</div>
		<div class='row'>
			<div class='cell'>
				City:
			</div>
			<div class='cell'>
				<g:textField name="billingCity" value="${params.billingCity}"/>
			</div>
		</div>
		<div class='row'>
			<div class='cell'>
				State:
			</div>
			<div class='cell'>
				<g:textField name="billingState" value="${params.billingState}"/>
			</div>
		</div>
		<div class='row'>
			<div class='cell'>
				ZipCode:
			</div>
			<div class='cell'>
				<g:textField name="billingZipCode" maxlength="5" value="${params.billingZipCode}"/>
			</div>
		</div>
		<h2>Shipping Address</h2>
		<div class='row'>
			<div class='cell'>
				Address 1:
			</div>
			<div class='cell'>
				<g:textField name="shippingAddress1" value="${params.shippingAddress1}"/>
			</div>
		</div>
		<div class='row'>
			<div class='cell'>
				Address 2:
			</div>
			<div class='cell'>
				<g:textField name="shippingAddress2" value="${params.shippingAddress2}"/>
			</div>
		</div>
		<div class='row'>
			<div class='cell'>
				City:
			</div>
			<div class='cell'>
				<g:textField name="shippingCity" value="${params.shippingCity}"/>
			</div>
		</div>
		<div class='row'>
			<div class='cell'>
				State:
			</div>
			<div class='cell'>
				<g:textField name="shippingState" value="${params.shippingState}"/>
			</div>
		</div>
		<div class='row'>
			<div class='cell'>
				ZipCode:
			</div>
			<div class='cell'> 
				<g:textField name="shippingZipCode" maxlength="5" value="${params.shippingZipCode}"/>
			</div>
		</div>
	</div>
	<g:submitButton name="submit" value="Create User"/>
</g:form>
<meta name="layout" content="main">
<h1>Thank You</h1>
<p> Thank you for your purchase!</p>
<p> Your purchase confirmation is below</p>

<div class="table">
	<div class="row">
		<div class="cell">Confirmation Number:</div>
		<div class="cell">${customerInvoice.confirmationNumber}</div>
	</div>
	<div class="row">
		<div class="cell">Purchase Price:</div>
		<div class="cell">${customerInvoice.totalCost}</div>
	</div>
</div>
<div>
	<g:each in="${customerInvoice.invoiceItems}" var="invoiceItem">
		<div>${invoiceItem.productNumber}</div>
	</g:each>
</div>

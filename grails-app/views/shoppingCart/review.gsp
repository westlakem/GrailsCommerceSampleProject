<meta name="layout" content="main">
<div id="paymentInfo"></div>
<div>
	<g:form name="enterPayment" action="enterPayment">
		<input type="hidden" name="invoiceNumber" value="${invoice.id}">
		<g:submitButton value="Pay Now!" name="submitForPayment"/>
	</g:form>
		<button type="button" name="submit" class = "paypalCheckout" value=""></button>
	</div>
	
	<table class="products">
		<thead>
			<tr>
				<th>Product<br>Number</th>
				<th>Name</th>
				<th>Description</th>
				<th>Total</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<g:each in="${cart}" var="item">
				<tr id="product${item.productInfo['productNumber']}" class = "table_border">
					<td id="pn${item.productInfo['productNumber']}">${item.productInfo['productNumber']}</td>
					<td id="name${item.productInfo['productNumber']}">${item.productInfo['name']}</td>
					<td id="desc${item.productInfo['productNumber']}">${item.productInfo['description']}</td>
					<g:if test="${item.productInfo['salePrice']!=null}">
						<td><span id="price${item.productInfo['productNumber']}">$${String.format("%.2f", (item.productInfo['salePrice'].toFloat() * item.qty.toInteger()).round(2))}</span></td>
					</g:if>
					<g:else>	
						<td><span id="price${item.productInfo['productNumber']}">$${String.format("%.2f", (item.productInfo['retailPrice'].toFloat() * item.qty.toInteger()).round(2))}</span></td>
					</g:else>	
					<td><ul class="no_bullet_list">
						<li> Quantity: <g:textField name="quantity${item.productInfo['productNumber']}" maxlength="2" size="1" value="${item.qty}" disabled = "true"></g:textField></li>
					</ul></td>
				</tr>
			</g:each>
			<tr id="subTotal">
				<td/>
				<td/>
				<td/>
				<td>Sub Total:</td>
				<td><div id="subTotal">$${invoice.subtotal}</div></td>
			</tr>
			<tr>
				<td/>
				<td/>
				<td/>
				<td>Shipping:</td>
				<td><div id="shipping">$${invoice.shippingCost}</div></td>
			<tr id="salesTax">
				<td/>
				<td/>
				<td/>
				<td class="totalsLabel">Tax:</td>
				<td><div id="salesTaxAmmt">$${invoice.tax}</div></td>
			</tr>
			<tr id="Total">
				<td/>
				<td/>
				<td/>
				<td> TOTAL:</td>
				<td><div id="total">$${invoice.total}</div></td>
			</tr>
		</tbody>
	</table>
	<g:form name="enterPayment" action="enterPayment">
		<input type="hidden" name="invoiceNumber" value="${invoice.id}">
		<g:submitButton value="Pay Now!" name="submitForPayment"/>
	</g:form>
		<button type="button" name="submit" class = "paypalCheckout" value=""></button>
	</div>
</div>
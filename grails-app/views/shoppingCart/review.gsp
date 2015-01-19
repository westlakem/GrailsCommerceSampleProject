<meta name="layout" content="main">
<div id="paymentInfo"></div>
<div>
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
				<td><div id="subTotalAmmt"></div></td>
			</tr>
			<tr>
				<td/>
				<td/>
				<td/>
				<td>Shipping:</td>
				<td><div id="shippingCost"></div></td>
			<tr id="salesTax">
				<td/>
				<td/>
				<td/>
				<td class="totalsLabel">Tax:</td>
				<td><div id="salesTaxAmmt">$${tax}</div></td>
			</tr>
			<tr id="Total">
				<td/>
				<td/>
				<td/>
				<td> TOTAL:</td>
				<td><div id="total">$${totalCost}</div></td>
			</tr>
		</tbody>
	</table>
	<g:render template="${grailsApplication.config.shoppingService.paymentProvider}"/>
</div>
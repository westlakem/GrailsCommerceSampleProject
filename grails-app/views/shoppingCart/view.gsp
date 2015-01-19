<meta name="layout" content="main">
<div id = "cartButtons" class = "cart_buttons">
		<g:link name = "emptyCart" class ="cart_buttons_img empty_cart_link" controller="shoppingCart" action="emptyCart"><input type="button" class="button empty_cart" value="Empty Cart"/></g:link>
		<g:link name = "checkout" class="right" controller="shoppingCart" action="checkout"><input type="button" class="button empty_cart" value="CHECKOUT"/></g:link>
</div>
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
						<li class="quantity_add ">Quantity: <g:textField name="quantity${item.productInfo['productNumber']}" class="pnqty right" maxlength="2" size="1" value="${item.qty}"></g:textField></li>
						<li><input id="${item.productInfo['productNumber']}" class="remove_from_cart button full_width" type="button" value="Remove From Cart"></li>
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
			<g:if test="${!tax == 0}">
			<tr id="salesTax">
				<td/>
				<td/>
				<td/>
				<td class="totalsLabel">Tax:</td>
				<td><div id="salesTaxAmmt">${tax}</div></td>
			</tr>
			</g:if>
			<tr id="Total">
				<td/>
				<td/>
				<td/>
				<td>Pre-Tax TOTAL:</td>
				<td><div id="totalAmmt"></div></td>
			</tr>
		</tbody>
	</table>
</div>
<div id = "cartButtons" class = "cart_buttons">
		<g:link name = "emptyCart" class ="cart_buttons_img empty_cart_link" controller="shoppingCart" action="emptyCart"><input type="button" class="button empty_cart" value="Empty Cart"/></g:link>
		<g:link name = "checkout" class="right" controller="shoppingCart" action="checkout"><input type="button" class="button empty_cart" value="CHECKOUT"/></g:link>
</div>
<head>
<meta name="layout" content="main">
</head>
<body>
	<div>
		<table>
			<thead>
			</thead>
				<tr>
					<th>SKU</th>
					<th>Product</th>
					<th>Description</th>
					<th>Price</th>
				</tr>
			<tbody>
				<g:each in="${products}" var ="product">
					<tr class="table_border">
						<td id="sku${product.squNumber}">${product.squNumber}</td>
						<td id="name${product.squNumber}">${product.name}</td>
						<td id="description${product.squNumber}">${product.description}</td>
						<g:if test="${product.salePrice!=null}">
						<td>
							<span style="color:red" id="regPrice${product.squNumber}"><s>${product.retailPrice}</s></span><br>
							<span id="price${product.squNumber}">${product.salePrice}</span>
						</td>
						</g:if>
						<g:else>
						<td id="regPrice${product.squNumber}">${product.retailPrice}</td>
						</g:else>
					</tr>
				</g:each>
			</tbody>
		</table>
	</div>
</body>
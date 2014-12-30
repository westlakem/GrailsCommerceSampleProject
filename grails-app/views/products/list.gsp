<head>
<meta name="layout" content="main">
</head>
<body>
	<g:render template="searchBar"></g:render>
	<div>
		<table class="products">
			<thead>
			</thead>
				<tr>
					<th>Product<br>Number</th>
					<th>Product</th>
					<th>Description</th>
					<th>Price</th>
				</tr>
			<tbody>
				<g:each in="${products}" var ="product">
					<tr class="table_border">
						<td id="sku${product.productNumber}">${product.productNumber}</td>
						<td id="name${product.productNumber}">${product.name}</td>
						<td id="description${product.productNumber}">${product.description}</td>
						<td>
							<ul class="no_bullet_list">
								<g:if test="${product.salePrice!=null}">
									<li style="color:red" id="regPrice${product.productNumber}"><s>${product.retailPrice}</s></li>
									<li id="price${product.productNumber}">${product.salePrice}</li>
								</g:if>
								<g:else>
									<li id="regPrice${product.productNumber}">${product.retailPrice}</li>
								</g:else>
								<li><input id="${product.productNumber}" class="add_to_cart button" type="button" value="Add To Cart"></li>
							</ul>
						</td>
					</tr>
				</g:each>
			</tbody>
		</table>
	</div>
</body>
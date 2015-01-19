<head>
<meta name="layout" content="main">
</head>
<body>
	<h1>Images for product ${item.productNumber}: ${item.name}</h1>
	<g:if test="${productImages == []}">
		No Images have been imported for product number ${item.productNumber}: ${item.name}
	</g:if>
	<g:else>
		<div style="width:100%; display:block">
			<ul class = "no_bullet_list horizontal_list">
				<g:each in="${productImages}" var="image">
					<li id="${image}Image" class = "itemImage">
						<g:img dir="images/products/2" file="${image}"/></br>
						<button id="${image}"class="removeImage" name="${item.productNumber}">Remove Image</button></br>
						<label>
							<g:radio name="primaryImage${item.productNumber}" checked="${item.primaryImage == image}" value="${image}" class="primaryImageSelector"></g:radio>
							Primary Image					
						</label>
					</li>
				</g:each>
			</ul>
		</div>
	</g:else>
	<div style="clear: both;">
		<h2> Add Images to product</h2>
		<uploadr:add name="productImageUploader${item.productNumber}" path="${folderLocation}" direction="up" maxVisible="8" unsupported="/my/controller/action" rating="false" voting="false" colorPicker="false" maxSize="204800000"/>
	</div>
</body>
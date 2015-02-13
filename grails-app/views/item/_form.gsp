<%@ page import="shoppingsolutionproject.Item" %>



<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'productNumber', 'error')} required">
	<label for="productNumber">
		<g:message code="item.productNumber.label" default="Product Number" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="productNumber" type="number" min="0" value="${itemInstance.productNumber}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="item.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${itemInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="item.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="description" cols="40" rows="5" required="" value="${itemInstance?.description}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'retailPrice', 'error')} required">
	<label for="retailPrice">
		<g:message code="item.retailPrice.label" default="Retail Price" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="retailPrice" value="${fieldValue(bean: itemInstance, field: 'retailPrice')}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'shippable', 'error')} ">
	<label for="shippingCost">
		<g:message code="item.shippable.label" default="Shippable" />
		
	</label>
	<g:checkBox id="shippable" name="shippable" value="${itemInstance?.shippable}" />

</div>

<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'shippingCost', 'error')} ">
	<label for="shippingCost">
		<g:message code="item.shippingCost.label" default="Shipping Cost" />
		
	</label>
	<g:field id = "shippingCost" name="shippingCost" value="${fieldValue(bean: itemInstance, field: 'shippingCost')}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'url', 'error')} required">
	<label for="url">
		<g:message code="item.url.label" default="Url" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="url" required="" value="${itemInstance?.url}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'salePrice', 'error')} ">
	<label for="salePrice">
		<g:message code="item.salePrice.label" default="Sale Price" />
		
	</label>
	<g:field name="salePrice" value="${fieldValue(bean: itemInstance, field: 'salePrice')}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'category', 'error')} required">
	<label for="category">
		<g:message code="item.category.label" default="Category" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="category" name="category.id" from="${shoppingsolutionproject.Category.list()}" optionKey="id" optionValue="name" required="" value="${itemInstance?.category?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'tangible', 'error')} ">
	<label for="tangible">
		<g:message code="item.tangible.label" default="Tangible" />
		
	</label>
	<g:checkBox name="tangible" value="${itemInstance?.tangible}" />

</div>

<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'tic', 'error')} required">
	<label for="tic">
		<g:message code="item.tic.label" default="Tic" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="tic" type="number" value="${itemInstance.tic}" required=""/>
	<g:link name="chooseTic" url='https://taxcloud.net/tic/default.aspx' target='_blank'>
		<button type="button" id="setTic">TIC Codes</button>
	</g:link>
	<div id="ticHelper"></div>
</div>


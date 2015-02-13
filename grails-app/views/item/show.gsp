
<%@ page import="shoppingsolutionproject.Item" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'item.label', default: 'Item')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-item" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-item" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list item">
			
				<g:if test="${itemInstance?.productNumber}">
				<li class="fieldcontain">
					<span id="productNumber-label" class="property-label"><g:message code="item.productNumber.label" default="Product Number" /></span>
					
						<span class="property-value" aria-labelledby="productNumber-label"><g:fieldValue bean="${itemInstance}" field="productNumber"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${itemInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="item.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${itemInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${itemInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="item.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${itemInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${itemInstance?.retailPrice}">
				<li class="fieldcontain">
					<span id="retailPrice-label" class="property-label"><g:message code="item.retailPrice.label" default="Retail Price" /></span>
					
						<span class="property-value" aria-labelledby="retailPrice-label"><g:fieldValue bean="${itemInstance}" field="retailPrice"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${itemInstance?.shippingCost}">
				<li class="fieldcontain">
					<span id="shippingCost-label" class="property-label"><g:message code="item.shippingCost.label" default="Shipping Cost" /></span>
					
						<span class="property-value" aria-labelledby="shippingCost-label"><g:fieldValue bean="${itemInstance}" field="shippingCost"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${itemInstance?.url}">
				<li class="fieldcontain">
					<span id="url-label" class="property-label"><g:message code="item.url.label" default="Url" /></span>
					
						<span class="property-value" aria-labelledby="url-label"><g:fieldValue bean="${itemInstance}" field="url"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${itemInstance?.salePrice}">
				<li class="fieldcontain">
					<span id="salePrice-label" class="property-label"><g:message code="item.salePrice.label" default="Sale Price" /></span>
					
						<span class="property-value" aria-labelledby="salePrice-label"><g:fieldValue bean="${itemInstance}" field="salePrice"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${itemInstance?.category}">
				<li class="fieldcontain">
					<span id="category-label" class="property-label"><g:message code="item.category.label" default="Category" /></span>
					
						<span class="property-value" aria-labelledby="category-label"><g:link controller="category" action="show" id="${itemInstance?.category?.id}">${itemInstance?.category?.name.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${itemInstance?.tangible}">
				<li class="fieldcontain">
					<span id="tangible-label" class="property-label"><g:message code="item.tangible.label" default="Tangible" /></span>
					
						<span class="property-value" aria-labelledby="tangible-label"><g:formatBoolean boolean="${itemInstance?.tangible}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${itemInstance?.tic}">
				<li class="fieldcontain">
					<span id="tic-label" class="property-label"><g:message code="item.tic.label" default="Tic" /></span>
					
						<span class="property-value" aria-labelledby="tic-label"><g:fieldValue bean="${itemInstance}" field="tic"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:itemInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${itemInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>

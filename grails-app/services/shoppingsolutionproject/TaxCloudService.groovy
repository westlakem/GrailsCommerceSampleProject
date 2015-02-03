package shoppingsolutionproject

import java.util.List;
import org.codehaus.groovy.grails.web.util.WebUtils

import net.taxcloud.Address;
import net.taxcloud.ArrayOfCartItem;
import net.taxcloud.CartItem
import net.taxcloud.ExemptionCertificate;
import net.taxcloud.LookupRsp
import net.taxcloud.TaxCloudSoap;
import grails.transaction.Transactional

@Transactional
class TaxCloudService {
	
	def taxCloud
	def grailsApplication	
	def shoppingCartService
	
	def uspsUserId
	def origin
	def loginId
	def apiKey

    def addressLookup(address){
		def addressValidationErrors = taxCloud.verifyAddress(
			uspsUserId, address.address1, address.address2, address.city, address.state, address.zipCode, '')
		return addressValidationErrors.errDescription
	}
	
	def taxAmmount(cart, address) {
		
		def web = WebUtils.retrieveGrailsWebRequest()
		def cartItems = compileArrayOfCartItem(cart)
		def originAddress = origin
		Address origin = new Address(address1:originAddress.address1, address2:originAddress.address2 , city:originAddress.city, state:originAddress.state, zip5:originAddress.zip, zip4:'')
		def shippingAddress = new Address(address1:address.address1, address2:address.address2, city:address.city, state:address.state, zip5:address.zipCode, zip4:'')
		LookupRsp lookUpResponse = taxCloud.lookup(
			loginId,
			apiKey,
			web.getSession().firstName.toString() + web.getSession().lastName.toString(),
			web.getSession().firstName.toString() + web.getSession().lastName.toString() + new Date().getDateTimeString(),
			cartItems,
			origin,
			shippingAddress,
			true, //delivered by seller
			null) // tax exempt #
		def taxAmmts = lookUpResponse.cartItemsResponse.cartItemResponse.taxAmount
		def taxAmmt = 0.00
		taxAmmts.each {tax ->
			taxAmmt += tax
		}
		return taxAmmt
	}
	
	private def compileArrayOfCartItem(List cart) {
		ArrayOfCartItem cartItems = new ArrayOfCartItem()
		cart.eachWithIndex {item, index ->
		def salePrice = item.productInfo['salePrice']
				def itemPrice
				if (salePrice){
					itemPrice = salePrice
				}
				else{
					itemPrice = item.productInfo['retailPrice']
				}
		def itemForLookup = Item.findByProductNumber(item.productInfo['productNumber'])
				CartItem ci = new CartItem(
						index: index, itemID: item.productInfo['productNumber'].toString(), tic: 91040, price: itemPrice, qty: shoppingCartService.getQuantity(itemForLookup).toInteger())
		cartItems.getCartItem().add(ci)
		}
		return cartItems
	}
}

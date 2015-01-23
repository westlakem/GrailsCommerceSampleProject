package shoppingsolutionproject

import java.util.List;

import net.taxcloud.Address;
import net.taxcloud.ArrayOfCartItem;
import net.taxcloud.CartItem
import net.taxcloud.ExemptionCertificate;
import net.taxcloud.LookupRsp
import net.taxcloud.TaxCloudSoap;
import grails.transaction.Transactional

@Transactional
class TaxCloudService {
	
	TaxCloudSoap taxCloud
	
	def grailsApplication

    def addressLookup(address1, address2, city, state, zip){
		def addressValidationErrors = taxCloud.verifyAddress(
			grailsApplication.config.shoppingService.taxCloud.uspsUserId,
			address1, address2, city, state, zip, '')
		return addressValidationErrors.errDescription
	}
	
	def taxAmmount(cart) {
		
		def cartItems = compileArrayOfCartItem(cart)
		def originAddress = grailsApplication.config.shoppingService.taxCloud.origin
		Address origin = new Address(address1:originAddress.address1, address2:originAddress.address2 , city:originAddress.city, state:originAddress.state, zip5:originAddress.zip, zip4:'')
		
		LookupRsp lookUpResponse = taxCloud.lookup(
			grailsApplication.config.shoppingService.taxCloud.loginId,
			grailsApplication.config.shoppingService.taxCloud.apiKey,
			session.getAttribute('firstName')+session.getAttribute('lastName'),
			session.getAttribute('firstName')+session.getAttribute('lastName')+new Date().getDateTimeString(),
			cartItems,
			origin,
			session.getAttribute('shippingAddress'),
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

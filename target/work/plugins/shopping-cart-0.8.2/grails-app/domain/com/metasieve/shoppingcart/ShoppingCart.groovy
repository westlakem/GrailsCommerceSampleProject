package com.metasieve.shoppingcart

class ShoppingCart {
	static hasMany = [items : ShoppingItem]
	
	Date dateCreated
   	Date lastUpdated
	
	String sessionID
	String lastURL
	
	Boolean checkedOut = false

	static constraints = {
		lastURL(url:true, nullable:true, blank: true)
		sessionID(blank:false)
	}
}

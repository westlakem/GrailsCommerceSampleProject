package pages

import geb.Page

class HomePage extends Page {
	static url = ""
	
	static at = {
		println(url)
		title ==~ /Welcome to Grails/
	}
	
	static content = {
		
	}
}
package pages

import geb.Page

class LoginPage extends Page {
	static url = "login/auth"
	
	static at = {
		title ==~ /Login/
	}
	
	static content = {
		
	}
	
	def login(username){
		
	}
}
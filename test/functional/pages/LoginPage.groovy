package pages

import geb.Page

class LoginPage extends Page {
	static url = "login/auth"
	
	static at = {
		title ==~ /Login/
	}
	
	static content = {
		
	}
	
	def login(user){
		$("form").j_username = user
		$("form").j_password = 'password'
		$("input", id: 'submit').click()
	}
}
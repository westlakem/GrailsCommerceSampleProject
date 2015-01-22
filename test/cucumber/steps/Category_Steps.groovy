import static cucumber.api.groovy.EN.*
import pages.LoginPage

Given(~/^I am an employee$/) { ->
	to LoginPage
	at LoginPage
	
	page.login('employee')
}
When(~/^I add a category$/) { ->
	assert false
}
Then(~/^the category is listed with the rest of the categories$/) { ->
	assert false
}
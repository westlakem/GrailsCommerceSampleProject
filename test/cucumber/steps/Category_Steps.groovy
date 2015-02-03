import static cucumber.api.groovy.EN.*
import pages.LoginPage
import pages.category.AddCategoryPage
import pages.category.ListCategoryPage

Given(~/^I am an employee$/) { ->
	to LoginPage
	at LoginPage
	
	page.login('employee')
}
When(~/^I add a category$/) { ->
	to AddCategoryPage
	at AddCategoryPage
	
	page.addCategory("New Category From Geb")
	page.submitCategory.click()
}
Then(~/^the category is listed with the categories$/) { ->
	to ListCategoryPage
	at ListCategoryPage
	
	
}
Feature: adding a category
	As an employee
	I want to add categories
	So that I can manage my products
	
Scenario: Adding a category as an employee
	Given I am an employee
	When I add a category
	Then the category is listed with the rest of the categories
	
	
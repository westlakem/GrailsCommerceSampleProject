import shoppingsolutionproject.Category;
import shoppingsolutionproject.Customer
import shoppingsolutionproject.Item
import shoppingsolutionproject.Role
import shoppingsolutionproject.User
import shoppingsolutionproject.UserRole

class BootStrap {
	
	def dataSource

    def init = { servletContext ->
    	def vehicle = new Category(name: 'Vehicle').save()
		def car = new Category(name: 'Car', parentCategory: vehicle).save()
		def truck = new Category(name: 'Truck', parentCategory: vehicle).save()
//		new Item(productNumber:1, name:"First Product", description: "This is the first product I'm adding for testing",
//				 shippingCost: 4.99, url: '/first', retailPrice: 19.99, salePrice: 16.99, category: car).save(failOnError: true)
//		new Item(productNumber:2, name:"Second Product", description: "This is the second product I'm adding for testing",
//				shippingCost: 4.99, url: '/second', retailPrice: 19.99, category: truck).save(failOnError: true)
//		new Item(productNumber:3, name:"First/Second Product", description: "This is the first/second(so third) product I'm adding for testing",
//				shippingCost: 4.99, url: '/third', retailPrice: 17.99, category: truck).save(failOnError: true)
				
				def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
				def employeeRole = new Role(authority: 'ROLE_EMPLOYEE').save(flush: true)
				def otherRole = new Role(authority: 'ROLE_OTHER').save(flush: true)
		  
				def adminUser = new User(username: 'admin', password: 'password').save(flush: true)
				def employeeUser = new User(username: 'employee', password: 'password').save(flush: true)
				def otherUser = new User(username: 'other', password: 'password').save(flush: true)
				
				UserRole.create adminUser, adminRole, true
				UserRole.create employeeUser, employeeRole, true
				UserRole.create otherUser, otherRole, true
    }
    def destroy = {
    }
}

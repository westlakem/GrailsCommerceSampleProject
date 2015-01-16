import shoppingsolutionproject.Category;
import shoppingsolutionproject.Item

class BootStrap {
	
	def dataSource

    def init = { servletContext ->
		def car = new Category(description: 'Car').save()
		def truck = new Category(description: 'Truck').save()
		new Item(productNumber:1, name:"First Product", description: "This is the first product I'm adding for testing",
				 shippingCost: 4.99, url: '/first', retailPrice: 19.99, salePrice: 16.99, category: car).save(failOnError: true)
		new Item(productNumber:2, name:"Second Product", description: "This is the second product I'm adding for testing",
				shippingCost: 4.99, url: '/second', retailPrice: 19.99, category: truck).save(failOnError: true)
		new Item(productNumber:3, name:"First/Second Product", description: "This is the first/second(so third) product I'm adding for testing",
				shippingCost: 4.99, url: '/third', retailPrice: 17.99, category: truck).save(failOnError: true)
    }
    def destroy = {
    }
}

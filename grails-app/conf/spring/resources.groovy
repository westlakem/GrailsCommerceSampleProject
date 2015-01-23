// Place your Spring DSL code here
import shoppingsolutionproject.CartService
import shoppingsolutionproject.TaxCloudService
import shoppingsolutionproject.TwoCheckoutService
import shoppingsolutionproject.AuthorizeDotNetService
beans = {
	cartService(CartService)
	taxService(TaxCloudService)
	switch(application.config.shoppingService.paymentProvider){
		case '2Checkout':
		paymentService(TwoCheckoutService)
		break
		case 'authorizeDotNet':
		paymentService(AuthorizeDotNetService)
		break
	}
}

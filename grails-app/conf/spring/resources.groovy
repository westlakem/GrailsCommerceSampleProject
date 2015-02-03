// Place your Spring DSL code here
import shoppingsolutionproject.CartService
import shoppingsolutionproject.TaxCloudService
import shoppingsolutionproject.TwoCheckoutService
import shoppingsolutionproject.AuthorizeDotNetService
beans = {
	cartService(CartService)
	taxService(TaxCloudService){
		uspsUserId = application.config.shoppingService.taxCloud.uspsUserId
		taxCloud = ref('taxCloud')
		shoppingCartService = ref('shoppingCartService')
		origin = application.config.shoppingService.taxCloud.origin
		loginId = application.config.shoppingService.taxCloud.loginId
		apiKey = application.config.shoppingService.taxCloud.apiKey
	}
	switch(application.config.shoppingService.paymentProvider){
		case '2Checkout':
		paymentService(TwoCheckoutService){
			privateKey = application.config.shoppingService.twoCheckout.privateKey
			environment = application.config.shoppingService.twoCheckout.environment
			sellerId = application.config.shoppingService.twoCheckout.sellerId
		}
		break
		case 'authorizeDotNet':
		paymentService(AuthorizeDotNetService){
			apiLoginID = application.config.shoppingService.authorizeDotNet.apiLoginID
			transactionKey = application.config.shoppingService.authorizeDotNet.transactionKey
			responseUrl = application.config.shoppingService.authorizeDotNet.responseUrl
			md5Hash = application.config.shoppingService.authorizeDotNet.md5Hash
			randomGenerator = new Random(System.currentTimeMillis())
		}
		break
	}
}

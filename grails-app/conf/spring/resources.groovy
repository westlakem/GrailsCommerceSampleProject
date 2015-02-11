// Place your Spring DSL code here
import shoppingsolutionproject.CartService
import shoppingsolutionproject.TaxCloudService
import shoppingsolutionproject.AuthorizeDotNetService
beans = {
	cartService(CartService)
	taxService(TaxCloudService){
		uspsUserId = application.config.shoppingService.uspsUserId
		taxCloud = ref('taxCloud')
		shoppingCartService = ref('shoppingCartService')
		origin = application.config.shoppingService.taxCloud.origin
		loginId = application.config.shoppingService.taxCloud.loginId
		apiKey = application.config.shoppingService.taxCloud.apiKey
	}
	switch(application.config.shoppingService.paymentProvider){
		case 'authorizeDotNet':
		paymentService(AuthorizeDotNetService){
			apiLoginID = application.config.shoppingService.authorizeDotNet.apiLoginID
			transactionKey = application.config.shoppingService.authorizeDotNet.transactionKey
			responseUrl = application.config.shoppingService.authorizeDotNet.responseUrl
			md5Hash = application.config.shoppingService.authroizeDotnet.md5Hash
			randomGenerator = new Random(System.currentTimeMillis())
			grailsApplication = ref('grailsApplication')
		}
		break
	}
}

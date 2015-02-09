In order to use Authorize.net payment solutions:

Go to http://www.authorize.net and setup a merchant account.
Once you have set up the account, go to your account settings and:
	setup MD5Hash
	get ApiLoginId & transaction keys
	set relayResponseUrl

Setup the following items in your config.groovy:
shoppingService.paymentProvider = 'authorizeDotNet'
shoppingService.authorizeDotNet.paymentUrl = 'https://test.authorize.net/gateway/transact.dll' //for testing
shoppingService.authorizeDotNet.apiLoginID = yourApiLoginId
shoppingService.authorizeDotNet.transactionKey = yourTransactionKey
shoppingService.authorizeDotNet.responseUrl = the url you set in your authorize.net merchant account
shoppingService.authroizeDotnet.md5Hash = yourTransactionKey

recommendations:
Use your fraud event filters as you see fit

In order to use 2Checkout payment solutions:

Go to 2checkout.com and setup a merchant account.

Setup the following items in your config.groovy:
shoppingService.paymentProvider = '2Checkout'
shoppingService.twoCheckout.sellerId = mySellerId
shoppingService.twoCheckout.publicKey = myPublicKey
shoppingService.twoCheckout.privateKey = myPrivateKey
shoppingService.twoCheckout.environment = 'sandbox' // for testing


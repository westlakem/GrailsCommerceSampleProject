THIS IS STILL A PROJECT IN INITAL DEVELOPMENT!

We highly recommend Authorize.net for the default payment provider, but as it does require a setup fee as well as a monthly fee, we include 2Checkout as a free alternative.  Authorize.net includes a full suite of tools for helping manage customer's payments.  If you would like to support the primary developer at no additional charge to you or your client, please sign up for Authorize.net at http://reseller.authorize.net/application/?resellerId=27456 OR 2Checkout at https://www.2checkout.com/referral?r=bf4c59f848. 

Authorize.net's offerings that are not available for 2Checkout include (but are not limited to):
* Full suite of Fraud Detection options
* Voiding a payment 
* Manual (keyed) payment by your staff
* Full view of settled and unsettled transactions

In order to use Authorize.net payment solutions:

Go to http://reseller.authorize.net/application/?resellerId=27456 and setup a merchant account.
Once you have set up the account, go to your account settings and:
* setup the MD5Hash
* get ApiLoginId & transaction keys
* set relayResponseUrl(IMPORTANT: this must be set to 'yoursite.com/shoppingCart/authorizePayment')

Setup the following items in your config.groovy:
* shoppingService.paymentProvider = 'authorizeDotNet'
* shoppingService.authorizeDotNet.paymentUrl = 'https://test.authorize.net/gateway/transact.dll' //for testing
* shoppingService.authorizeDotNet.apiLoginID = yourApiLoginId
* shoppingService.authorizeDotNet.transactionKey = yourTransactionKey
* shoppingService.authorizeDotNet.responseUrl = 'yoursite.com/shoppingCart/authorizePayment' *
* shoppingService.authroizeDotnet.md5Hash = yourMD5Hash

In order to use 2Checkout payment solutions:

Go to https://www.2checkout.com/referral?r=bf4c59f848 and setup a merchant account.
Once you have set up the account, go to your account settings and get your:
* sellerId
* publicKey
* privateKey

Setup the following items in your config.groovy:
* shoppingService.paymentProvider = '2Checkout'
* shoppingService.twoCheckout.sellerId = mySellerId
* shoppingService.twoCheckout.publicKey = myPublicKey
* shoppingService.twoCheckout.privateKey = myPrivateKey
* shoppingService.twoCheckout.environment = 'sandbox' // for testing

Optional Fields include:
* shoppingService.acceptPaypal = true
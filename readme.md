#ROCS is a project in initial development!#

This plugin is being developed as an eCommerce platform for Grails.

## What You Will Need ##

In order to use this platform, you'll need:

* A Grails Application ( version 2.x )
* A database
* A USPS shipping API account
* A taxCloud account
* An Authorize.net Payment Gateway & Merchant Account

## USPS Shipping API ##

The USPS shipping API is used to validate billing and shipping addresses entered by your customers.  You can sign up for the account by going to https://secure.shippingapis.com/registration/

After you sign up, you will need to add your USPS user id as follows:

* shoppingService.uspsUserId = yourUSPSID

## Tax Cloud ##

Tax Cloud allows you to accurately charge the correct tax rate for transactions.  It is a free service provided to eliminate the guess work when it comes to calculating sales tax. You will need to sign up at https://taxcloud.net/ 

Once you have signed up, you will need to complete the following:

* Setup all your business locations (This determines when / where you need to charge tax)
* Register your website(Make sure you add a default TIC as this will be the tax information used to determine taxable items)

After that is completed, you will need to add the following to your config.groovy

* shoppingService.taxCloud.loginId = yourAPIID
* shoppingService.taxCloud.apiKey = yourAPIKey

## Authorize.net Account ##

This is the payment provider.  This is the service that actually processes the payment.

I would appreciate you supporting my development efforts by signing up through my reseller account.  You can do this by going to http://reseller.authorize.net/application/?resellerId=27456 and completing the registration.  This is at no additional cost to you or your client.

Once you have set up the account, go to your account settings and:

* setup the MD5Hash
* get ApiLoginId & transaction keys
* set relayResponseUrl(IMPORTANT: this must be set to 'yoursite.com/shoppingCart/authorizePayment')

Setup the following items in your config.groovy:

* shoppingService.paymentProvider = 'authorizeDotNet'
* shoppingService.authorizeDotNet.paymentUrl = 'https://test.authorize.net/gateway/transact.dll' //for testing
* shoppingService.authorizeDotNet.apiLoginID = yourApiLoginId
* shoppingService.authorizeDotNet.transactionKey = yourTransactionKey
* shoppingService.authorizeDotNet.responseUrl = 'yoursite.com/shoppingCart/authorizePayment'
* shoppingService.authroizeDotnet.md5Hash = yourMD5Hash

Optional Fields include:

* shoppingService.acceptPaypal = true

## Project information ##

For updates on the progress of this plugin, or to contribute, please visit https://trello.com/b/US35VG1V

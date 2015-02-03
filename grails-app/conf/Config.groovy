// locations to search for config files that get merged into the main config;
// config files can be ConfigSlurper scripts, Java properties files, or classes
// in the classpath in ConfigSlurper format

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if (System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination

// The ACCEPT header will not be used for content negotiation for user agents containing the following strings (defaults to the 4 major rendering engines)
grails.mime.disable.accept.header.userAgents = ['Gecko', 'WebKit', 'Presto', 'Trident']
grails.mime.types = [ // the first one is the default format
    all:           '*/*', // 'all' maps to '*' or the first available format in withFormat
    atom:          'application/atom+xml',
    css:           'text/css',
    csv:           'text/csv',
    form:          'application/x-www-form-urlencoded',
    html:          ['text/html','application/xhtml+xml'],
    js:            'text/javascript',
    json:          ['application/json', 'text/json'],
    multipartForm: 'multipart/form-data',
    rss:           'application/rss+xml',
    text:          'text/plain',
    hal:           ['application/hal+json','application/hal+xml'],
    xml:           ['text/xml', 'application/xml']
]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// Legacy setting for codec used to encode data with ${}
grails.views.default.codec = "html"

// The default scope for controllers. May be prototype, session or singleton.
// If unspecified, controllers are prototype scoped.
grails.controllers.defaultScope = 'singleton'

// GSP settings
grails {
    views {
        gsp {
            encoding = 'UTF-8'
            htmlcodec = 'xml' // use xml escaping instead of HTML4 escaping
            codecs {
                expression = 'html' // escapes values inside ${}
                scriptlet = 'html' // escapes output from scriptlets in GSPs
                taglib = 'none' // escapes output from taglibs
                staticparts = 'none' // escapes output from static template parts
            }
        }
        // escapes all not-encoded output at final stage of outputting
        // filteringCodecForContentType.'text/html' = 'html'
    }
}


grails.converters.encoding = "UTF-8"
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false

// configure passing transaction's read-only attribute to Hibernate session, queries and criterias
// set "singleSession = false" OSIV mode in hibernate configuration after enabling
grails.hibernate.pass.readonly = false
// configure passing read-only to OSIV session by default, requires "singleSession = false" OSIV mode
grails.hibernate.osiv.readonly = false

cxf {
	client {
		taxCloud {
			clientInterface = net.taxcloud.TaxCloudSoap
			serviceEndpointAddress = 'https://api.taxcloud.net/1.0/TaxCloud.asmx'
//			secured = [true or false] //optional - defaults to false
//			contentType = [String value of http content type] - defaults to 'text/xml; charset=UTF8' 

			//wsdl config
			wsdl = 'https://api.taxcloud.net/1.0/TaxCloud.asmx?wsdl'
			wsdlArgs = ["-autoNameResolution", "-validate"] //optional - only used by wsdl2java script
//			namespace = [package name to use for generated classes] //optional - uses packages from wsdl if not provided
//			client = [true or false] //optional - used to tell wsdl2java to output sample clients, usually not needed - defaults to false
//			bindingFile = [Specifies JAXWS or JAXB binding file or XMLBeans context file] //optional
//			outputDir = [location to output generated files] //optional - defaults to src/java
		}
	}
}

environments {
    development {
        grails.logging.jul.usebridge = true
		
		////////////////////////////////////////////////////////////////////////////////////
		// these are needed for the plugin
		
		//TODO: remove these before final plugin integration
		shoppingService.taxCloud.loginId = '35942020'
		shoppingService.taxCloud.apiKey = '191D12F2-47BB-4612-9A9E-B67B5E64F790'
		shoppingService.taxCloud.uspsUserId = '380NONEY4790'
		shoppingService.taxCloud.origin = [address1: '3646 Ripley Trail Drive', address2: '', city:'Pickerington', state:'Ohio', zip: '43147']
		
		shoppingService.paymentProvider='authorizeDotNet'
		shoppingService.authorizeDotNet.apiLoginID = '2Pk2Cud93'
		shoppingService.authorizeDotNet.transactionKey = '695bmUwYe7U93S5q'
		shoppingService.authorizeDotNet.responseUrl = 'http://65.60.228.234:8080/ShoppingSolutionProject/shoppingCart/paymentAuthorizing'
		shoppingService.authroizeDotnet.md5Hash = 'thisVeryImportant'
		shoppingService.twoCheckout.sellerId = '901262262'
		shoppingService.twoCheckout.publicKey = '47C59E26-C88E-4FAB-A339-451E01EFCE33'
		shoppingService.twoCheckout.privateKey = '1474E54F-F9BF-4262-A2B5-522CD2E2D62C'
		shoppingService.twoCheckout.environment = 'sandbox'
		
		// Added by the Spring Security Core plugin:
		
    }
	test{
		
		grails.plugin.springsecurity.rejectIfNoRule = false
		grails.plugin.springsecurity.fii.rejectPublicInvocations = false
		
	}
    production {
        grails.logging.jul.usebridge = false
        // TODO: grails.serverURL = "http://www.changeme.com"
		
    }
}

// log4j configuration
log4j.main = {
    // Example of changing the log pattern for the default console appender:
    //
    //appenders {
    //    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
    //}

    error  'org.codehaus.groovy.grails.web.servlet',        // controllers
           'org.codehaus.groovy.grails.web.pages',          // GSP
           'org.codehaus.groovy.grails.web.sitemesh',       // layouts
           'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
           'org.codehaus.groovy.grails.web.mapping',        // URL mapping
           'org.codehaus.groovy.grails.commons',            // core / classloading
           'org.codehaus.groovy.grails.plugins',            // plugins
           'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
           'org.springframework',
           'org.hibernate',
           'net.sf.ehcache.hibernate'
}


// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.rejectIfNoRule = true
grails.plugin.springsecurity.fii.rejectPublicInvocations = true

grails.plugin.springsecurity.logout.postOnly = false
grails.plugin.springsecurity.password.bcrypt.logrounds = 15
grails.plugin.springsecurity.roleHierarchy = '''
ROLE_ADMIN > ROLE_EMPLOYEE'''
grails.plugin.springsecurity.userLookup.userDomainClassName = 'shoppingsolutionproject.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'shoppingsolutionproject.UserRole'
grails.plugin.springsecurity.authority.className = 'shoppingsolutionproject.Role'
grails.plugin.springsecurity.securityConfigType = "InterceptUrlMap"
grails.plugin.springsecurity.useSessionFixationPrevention = false //shopping cart is session based.
grails.plugin.springsecurity.interceptUrlMap = [
		'/':                              			['permitAll'],
        '/index':                         			['permitAll'],
        '/index.gsp':                     			['permitAll'],
        '/assets/**':                     			['permitAll'],
        '/**/js/**':                      			['permitAll'],
        '/**/css/**':                     			['permitAll'],
        '/**/images/**':                  			['permitAll'],
        '/**/favicon.ico':                			['permitAll'],
        '/login/**':						  		['permitAll'],
        '/logout/**':						  		['permitAll'],
        '/products/**':						  		['permitAll'],
        '/shoppingCart/**':					  		['permitAll'],
        '/category/**': 				  			['ROLE_EMPLOYEE'],
        '/invoice/**':					  			['ROLE_EMPLOYEE'],
        '/item/**':						  			['ROLE_EMPLOYEE'],
        '/user/**':						  			['ROLE_ADMIN'],
		'/dbconsole/**':				  			['ROLE_ADMIN'],
		'/shoppingCart/checkoutAsAuthenticated': 	['isAuthenticated()']
]
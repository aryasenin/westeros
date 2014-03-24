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
grails.mime.types = [html: ['text/html', 'application/xhtml+xml'],
        xml: ['text/xml', 'application/xml'],
        text: 'text/plain',
        js: 'text/javascript',
        rss: 'application/rss+xml',
        atom: 'application/atom+xml',
        css: 'text/css',
        csv: 'text/csv',
        pdf: 'application/pdf',
        rtf: 'application/rtf',
        excel: ['application/octet-stream'],
        xls: ['application/vnd.ms-excel', 'application/msexcel', 'application/xls', ''],
        ods: 'application/vnd.oasis.opendocument.spreadsheet',
        all: '*/*',
        json: ['application/json', 'text/json'],
        doc: ['application/msword'],
        docx: ['application/vnd.openxmlformats-officedocument.wordprocessingml.document'],
        xlsx: ['application/vnd.openxmlformats-officedocument.spreadsheetml.sheet'],
        mp3: ['audio/mp3'],
        zip: ['application/zip'],
        rar: ['application/x-rar-compressed'],
        form: 'application/x-www-form-urlencoded',
        jpg: ['image/jpg'],
        jpeg: ['image/jpeg'],
        png: ['image/png'],
        tiff: ['image/tiff'],
        ico: ['image/vnd.microsoft.icon'],
        ppt: ['application/vnd.ms-powerpoint'],
        pptx: ['application/vnd.openxmlformats-officedocument.presentationml.presentation'],
        multipartForm: 'multipart/form-data'
]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// What URL patterns should be processed by the resources plugin
grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*']

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
        filteringCodecForContentType {
            //'text/html' = 'html'
        }
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
grails.web.disable.multipart = false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false

environments {
    development {
        grails.logging.jul.usebridge = true
    }
    production {
        grails.logging.jul.usebridge = false
        // TODO: grails.serverURL = "http://www.changeme.com"
    }
}


environments {
    development {
        // log4j configuration en developpement
        log4j = {
            appenders {
                rollingFile name: "myAppender", maxFileSize: 10240000, file: "/tmp/${appName}.log"
            }

            error 'org.codehaus.groovy.grails.web.servlet',  //  controllers
                    'org.codehaus.groovy.grails.web.pages', //  GSP
                    'org.codehaus.groovy.grails.web.sitemesh', //  layouts
                    'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
                    'org.codehaus.groovy.grails.web.mapping', // URL mapping
                    'org.codehaus.groovy.grails.commons', // core / classloading
                    'org.codehaus.groovy.grails.plugins', // plugins
                    'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
                    'org.springframework',
                    'org.hibernate',
                    'net.sf.ehcache.hibernate'

            warn myAppender: 'grails.app'
            info myAppender: 'grails.app'
            debug myAppender: 'grails.app'

            //debug myAppender: 'grails.app.service'

        }
    }
    production {
        // log4j configuration
        log4j = {
            // Example of changing the log pattern for the default console appender:
            //
            //appenders {
            //    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
            //}

            error 'org.codehaus.groovy.grails.web.servlet',        // controllers
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
    }
}


grails.mail.jndiName = "java:comp/env/mail/thewallmail"

grails.naming.entries = [
        "jdbc/thewall": [
                type: "javax.sql.DataSource", //required
                auth: "Container", // optional
                description: "Source de données pour la base de The Wall", //optional
                driverClassName: "com.mysql.jdbc.Driver",
                //dialect: "org.hibernate.dialect.MySQL5InnoDBDialect",
                url: "jdbc:mysql://localhost/thewall?autoreconnect=true",
                username: "appuser",
                password: "appuser",
                maxActive: "30",
                maxIdle: "4"
        ],
        "mail/thewallmail": [
                auth: "Container",
                type: "javax.mail.Session",
                username: "westeros.thewall@gmail.com",
                password: "thewall%2014",
                "mail.user": "westeros.thewall@gmail.com",
                "mail.smtp.host": "smtp.gmail.com",
                "mail.smtp.port": "465",
                "mail.smtp.auth": "true",
                "mail.smtp.socketFactory.port": "465",
                "mail.smtp.socketFactory.class": "javax.net.ssl.SSLSocketFactory",
                "mail.smtp.socketFactory.fallback": "false",
                "mail.smtp.starttls.enable": "true"
        ]
]

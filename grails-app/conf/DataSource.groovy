dataSource {
    pooled = false
    dialect = org.hibernate.dialect.MySQL5InnoDBDialect
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
//    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4

    //cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
}

// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "create-drop" // one of 'create', 'create-drop','update'
            jndiName = "java:comp/env/jdbc/thewall"
        }
    }

    test {
        dataSource {
            jndiName = "java:comp/env/jdbc/thewall"
            dbCreate = "update" // one of 'create', 'create-drop','update'
        }
    }

    production {
        dataSource {
            jndiName = "java:comp/env/jdbc/thewall"
            dbCreate = "update" // one of 'create', 'create-drop','update'
            properties {
                maxActive = -1
                minEvictableIdleTimeMillis = 1800000
                timeBetweenEvictionRunsMillis = 1800000
                numTestsPerEvictionRun = 3
                testOnBorrow = true
                testWhileIdle = true
                testOnReturn = false
                validationQuery = "SELECT 1"
                jdbcInterceptors = "ConnectionState"
            }
        }
    }
}

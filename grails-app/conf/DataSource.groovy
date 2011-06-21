dataSource {
    pooled = true
    driverClassName = "org.hsqldb.jdbcDriver"
    username = "sa"
    password = ""
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = true
    cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
}
// environment specific settings
environments {
    development {
        dataSource {
			dialect = org.hibernate.dialect.MySQLDialect.class
			driverClassName = 'com.mysql.jdbc.Driver'
			username = 'eventfinder'
			password = 'secret'
            dbCreate = "create-drop" // one of 'create', 'create-drop','update'
            url = "jdbc:mysql://localhost/eventfinder"
        }
    }
    test {
		dataSource {
			dialect = org.hibernate.dialect.MySQLDialect.class
			driverClassName = 'com.mysql.jdbc.Driver'
			username = 'eftest'
			password = 'secret'
            dbCreate = "create-drop" // one of 'create', 'create-drop','update'
            url = "jdbc:mysql://localhost/eftest"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "FIXME jdbc:hsqldb:file:prodDb;shutdown=true"
        }
    }
}

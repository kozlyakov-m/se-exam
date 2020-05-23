package com.kozlyakov.project.di

import com.google.inject.AbstractModule
import com.google.inject.persist.jpa.JpaPersistModule

import org.flywaydb.core.Flyway
import java.util.*

class DatabaseModule : AbstractModule() {

    private val persistenceUnitName = "AaaPersistenceUnit"
    private var envDriver: String = ""
    private var envUrl: String = ""
    private var envLogin: String = ""
    private var envPass: String = ""
    private var hibernateDialect = ""
    private val migrationLocation = "filesystem:C:\\Users\\kozly\\IdeaProjects\\exam\\src\\main\\resources\\db\\migration"

    override fun configure() {
        super.configure()
        setEnv()
        val jpaModule = JpaPersistModule(persistenceUnitName)
        jpaModule.properties(getDatabaseEnvironments())
        install(jpaModule)
        bind(PersistenceInitializer::class.java).asEagerSingleton()
        migrate()
    }

    private fun getDatabaseEnvironments(): MutableMap<String, Any> {
        val envConfig: MutableMap<String, Any> = HashMap()
        envConfig["javax.persistence.jdbc.url"] = envUrl
        envConfig["javax.persistence.jdbc.user"] = envLogin
        envConfig["javax.persistence.jdbc.password"] = envPass
        envConfig["javax.persistence.jdbc.driver"] = envDriver
        envConfig["hibernate.dialect"] = hibernateDialect
        return envConfig
    }

    private fun setEnv() {
        val url = System.getenv("DATABASE_URL")
        if (url.isNullOrEmpty()) {
            envUrl = "jdbc:h2:file:./AAA"
            envLogin = "sa"
            envPass = ""
            envDriver = "org.h2.Driver"
            hibernateDialect = "org.hibernate.dialect.H2Dialect"
        } else {
            envUrl = System.getenv("JDBC_DATABASE_URL")
            envLogin = System.getenv("JDBC_DATABASE_USERNAME")
            envPass = System.getenv("JDBC_DATABASE_PASSWORD")
            envDriver = "org.postgresql.Driver"
            hibernateDialect = "org.hibernate.dialect.PostgreSQLDialect"
        }
    }

    private fun migrate() {
        Flyway
                .configure()
                .dataSource(envUrl, envLogin, envPass)
                //.locations(migrationLocation)
                .load()
                .migrate()
    }
}

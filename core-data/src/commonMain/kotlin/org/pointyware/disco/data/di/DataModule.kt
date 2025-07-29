package org.pointyware.disco.data.di

import app.cash.sqldelight.db.SqlDriver
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.SupervisorJob
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.pointyware.disco.data.hosts.db.HostDb
import org.pointyware.disco.local.DriverFactory
import org.pointyware.disco.local.Persistence
import org.pointyware.disco.local.createOrMigrate

val dataQualifier = named("data")

/**
 */
fun dataModule() = module {
    single<CoroutineDispatcher>(qualifier = dataQualifier) {
        Dispatchers.IO
    }
    single<CoroutineScope>(qualifier = dataQualifier) {
        CoroutineScope(get<CoroutineDispatcher>(qualifier = dataQualifier) + SupervisorJob())
    }

    single<Lazy<HostDb>> { lazy {
        val driver: SqlDriver = get()
        HostDb.Schema.createOrMigrate(driver)
        HostDb(driver)
    } }
    single<SqlDriver> {
        val persistence: Persistence? = getOrNull()
        val driverFactory = get<DriverFactory>()
        driverFactory.createSqlDriver(persistence ?: Persistence.File)
    }

    includes(
        platformDataModule()
    )
}

expect fun platformDataModule(): Module

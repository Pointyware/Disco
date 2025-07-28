package org.pointyware.disco.data.di

import org.koin.dsl.module
import org.pointyware.disco.data.JvmDriverFactory
import org.pointyware.disco.local.DriverFactory

/**
 * Desktop implementation platform-specific data module.
 */
actual fun platformDataModule() = module {
    single<DriverFactory> {
        JvmDriverFactory()
    }
}

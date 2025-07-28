package org.pointyware.disco.data.di

import org.koin.dsl.module
import org.pointyware.disco.data.AndroidDriverFactory
import org.pointyware.disco.local.DriverFactory

actual fun platformDataModule() = module {
    single<DriverFactory> {
        AndroidDriverFactory(get())
    }
}

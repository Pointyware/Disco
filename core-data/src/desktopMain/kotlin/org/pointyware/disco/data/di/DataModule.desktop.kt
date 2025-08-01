/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

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

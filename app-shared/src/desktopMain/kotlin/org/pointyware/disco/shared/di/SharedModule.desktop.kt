/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.shared.di

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformSharedModule(): Module {
    return module {
        single<CoroutineScope>(qualifier = appQualifier) {
            CoroutineScope(SupervisorJob() + Dispatchers.Main)
        }
    }
}

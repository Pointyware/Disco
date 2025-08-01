/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import org.koin.mp.KoinPlatform.getKoin

/**
 * A convenience function to get a ViewModel across platforms. Subsequent invocations will return
 * the same instance through [remember].
 *
 * This implementation currently uses Koin for dependency injection.
 */
@Composable
inline fun <reified T: ViewModel> rememberViewModel(): T = remember { getKoin().get<T>() }

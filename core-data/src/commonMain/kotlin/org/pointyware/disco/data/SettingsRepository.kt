/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.data

import kotlinx.coroutines.flow.Flow

/**
 * A repository of application settings that are stored as String key/value pairs.
 */
interface SettingsRepository {

    val onValueChange: Flow<String>
    suspend fun get(key: String): String?
    suspend fun set(key: String, value: String)
    suspend fun remove(key: String)

    suspend fun persist()
}

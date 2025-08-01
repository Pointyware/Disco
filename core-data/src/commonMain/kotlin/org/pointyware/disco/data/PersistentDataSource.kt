/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.data

/**
 *
 */
interface PersistentDataSource {
    suspend fun get(key: String): String?
    suspend fun set(key: String, value: String)
    suspend fun remove(key: String)

    /**
     * Manually persist the data source.
     */
    suspend fun persist()
}

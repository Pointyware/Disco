/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.entities.math

/**
 * Provides monotonically increasing ids.
 *
 * *warning* - not thread safe; invoking from multiple thread may result in duplicate ids
 */
object IdProvider {
    private var id = 0L

    fun getNextId(): Long {
        return id++
    }
}

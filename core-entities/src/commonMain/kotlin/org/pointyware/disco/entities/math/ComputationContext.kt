/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.entities.math

/**
 *
 */
class ComputationContext() {
    private val map = mutableMapOf<ComputationKey<*>, Any>()

    fun <T: Any> put(key: ComputationKey<T>, value: T) {
        map[key] = value
    }

    fun <T: Any> get(key: ComputationKey<T>): T {
        @Suppress("UNCHECKED_CAST")
        return map[key] as T
    }
}

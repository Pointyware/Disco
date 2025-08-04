/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.entities.math

import kotlin.reflect.KClass

/**
 * Keys which identify a specific element of computation in some context map.
 */
data class ComputationKey<out T: Any>(
    val id: Long,
    val type: KClass<out T>
) {
}

inline fun <reified T: Any> Long.key(type: KClass<T> = T::class): ComputationKey<T> {
    return ComputationKey(this, type)
}

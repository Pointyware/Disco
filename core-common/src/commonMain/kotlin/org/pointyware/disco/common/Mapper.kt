/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.common

/**
 * A simple functional interface for mapping an input of type [I] to an output of type [O].
 *
 * This interface is used to define a transformation from one type to another.
 *
 * @param I the input type
 * @param O the output type
 */
fun interface Mapper<in I, out O> {
    fun map(input: I): O
}

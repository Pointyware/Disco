/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.entities.blocks

/**
 * A neural network block is a sub-unit of a complex neural network
 * that performs a specific function.
 */
interface Block {
    val parameterCount: Int
    // fun calculate(context: Map<Long, Tensor>): Tensor
}

/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.entities.blocks

import org.pointyware.disco.entities.math.ComputationComponent

/**
 * A neural network block is a sub-unit of a complex neural network
 * that performs a specific function.
 */
interface Block: ComputationComponent {
    /**
     * The number of parameters in the block.
     */
    val parameterCount: Int
}

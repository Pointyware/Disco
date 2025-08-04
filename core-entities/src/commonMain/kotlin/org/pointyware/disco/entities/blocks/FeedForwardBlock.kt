/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.entities.blocks

import org.pointyware.disco.entities.ExperimentalNetworkApi
import org.pointyware.disco.entities.math.ComputationGraph

/**
 *
 */
class FeedForwardBlock: Block {
    override val parameterCount: Int
        get() = 0

    @ExperimentalNetworkApi
    override val graph: ComputationGraph
        get() = TODO("Not yet implemented")
}

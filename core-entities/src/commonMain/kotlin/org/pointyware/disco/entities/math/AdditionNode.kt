/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.entities.math

import org.pointyware.disco.entities.ExperimentalNetworkApi

@OptIn(ExperimentalNetworkApi::class)
class AdditionNode(
    override val inputEdges: Set<ComputationKey<Int>>,
    val output: ComputationKey<Int>
): ComputationGraph.Node {

    override val outputEdges: Set<ComputationKey<Int>> get() = setOf(output)

    override fun compute(context: ComputationContext) {
        val outputValue = inputEdges.sumOf {
            context.get(it)
        }
        context.put(output, outputValue)
    }
}

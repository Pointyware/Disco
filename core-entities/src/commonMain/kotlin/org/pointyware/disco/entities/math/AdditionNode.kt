/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.entities.math

import org.pointyware.disco.entities.ExperimentalNetworkApi

@OptIn(ExperimentalNetworkApi::class)
data class AdditionNode(
    override val inputs: Set<ComputationKey<Int>>,
    val outputId: ComputationKey<Int>,
): ComputationGraph.Node {
    override val outputs: Set<ComputationKey<Int>> = setOf(outputId)

    override fun compute(context: ComputationContext) {
        val outputValue = inputs.sumOf {
            context.get(it)
        }
        context.put(outputId, outputValue)
    }

    override fun toString(): String {
        return "{$inputs -> $outputId}"
    }
}

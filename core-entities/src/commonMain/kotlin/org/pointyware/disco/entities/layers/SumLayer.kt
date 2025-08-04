/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.entities.layers

import org.pointyware.disco.entities.ExperimentalNetworkApi
import org.pointyware.disco.entities.math.ComputationComponent
import org.pointyware.disco.entities.math.ComputationContext
import org.pointyware.disco.entities.math.ComputationGraph
import org.pointyware.disco.entities.math.ComputationKey
import org.pointyware.disco.entities.tensors.Tensor

/**
 *
 * TODO: implement Layer interface after graph calculations
 */
class SumLayer(
    val inputIds: Set<ComputationKey<Tensor>>,
    val outputId: ComputationKey<Tensor>,
): ComputationComponent {
    @ExperimentalNetworkApi
    override val graph: ComputationGraph
        get() = ComputationGraph(
            nodes = emptySet()
        )

    @OptIn(ExperimentalNetworkApi::class)
    class SumNode(
        override val id: ComputationKey<Tensor>,
        val inputIds: Set<ComputationKey<Tensor>>,
    ): ComputationGraph.Node {

        override val inputEdges: Set<ComputationKey<*>>
            get() = inputIds

        override fun compute(context: ComputationContext) {
            val output = context.get(id)
            inputIds.forEach {
                output += context.get(it)
            }
        }
    }
}

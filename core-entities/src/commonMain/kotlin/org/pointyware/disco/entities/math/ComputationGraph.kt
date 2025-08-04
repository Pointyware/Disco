/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.entities.math

import org.pointyware.disco.entities.ExperimentalNetworkApi

/**
 * A computation graph consists of nodes that represent operations and edges that
 * represent dependencies between operations in the graph.
 *
 * A computation graph works on a ContextMap with values identified by typed keys.
 * The computation retrieves the identified values in a type-safe manner to perform
 * its operations, before inserting the results back into the map.
 */
@ExperimentalNetworkApi
class ComputationGraph(
    val nodes: Set<Node>,
    val edges: Set<Edge>
) {

    val computeOrder: List<Node> by lazy {
        TODO("Not yet implemented")
    }

    fun compute(context: ComputationContext) {
        computeOrder.forEach { node ->
            node.compute(context)
        }
    }

    /**
     * A computation node represents an operation in the computation graph.
     *
     * Nodes can have many inputs and many outputs.
     */
    abstract class Node {
        /**
         * Computes the output value of the node in terms of its inputs.
         */
        abstract fun compute(context: ComputationContext)

        /**
         * Computes the derivative of the output value of the node in terms of its inputs.
         */
        abstract fun derivative(context: ComputationContext)
    }
    /**
     * A computation edge represents a dependency between two computation nodes in the graph.
     */
    data class Edge(val from: Node, val to: Node)
}

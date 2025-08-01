/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.entities.math

/**
 * A computation graph consists of nodes that represent operations and edges that
 * represent dependencies between operations in the graph.
 *
 * A computation graph works on a ContextMap with values identified by typed keys.
 * The computation retrieves the identified values in a type-safe manner to perform
 * its operations, before inserting the results back into the map.
 */
class ComputationGraph(
    val nodes: Set<Node<*>>,
    val edges: Set<Edge<*, *>>
) {

    /**
     * A computation node represents an operation in the computation graph.
     */
    abstract class Node<O: Any>(
        val inputs: Set<ComputationKey<*>>,
        val output: ComputationKey<O>
    ) {
        /**
         * Computes the output value of the node in terms of its inputs.
         */
        abstract fun compute(): O

        /**
         * Computes the derivative of the output value of the node in terms of its inputs.
         */
        abstract fun derivative(): O
    }
    /**
     * A computation edge represents a dependency between two computation nodes in the graph.
     */
    data class Edge<I: Any, O: Any>(
        val from: Node<I>,
        val to: Node<O>
    )
}

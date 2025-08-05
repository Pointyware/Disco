/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.entities.math

import org.pointyware.disco.entities.ExperimentalNetworkApi

/**
 * A computation graph consists of nodes that represent operations on inputs
 * that produce one or more outputs. The collection of nodes form a hypergraph.
 *
 * A computation graph works on a [ComputationContext] with values identified
 * by typed keys. The computation retrieves the identified values in a type-safe
 * manner to perform its operations, before inserting the results back into the map.
 */
@ExperimentalNetworkApi
class ComputationGraph(
    val nodes: Set<Node>
) {

    /**
     * Determines the order in which the nodes should be computed, using a topological sort.
     */
    val computeOrder: List<Node> by lazy {
        val visited = mutableSetOf<Node>()
        val complete = mutableSetOf<Node>()
        val result = mutableListOf<Node>()
        val nodeNeighbors: Map<Node, List<Node>> = nodes.associateWith { node ->
            // find all nodes whose inputs depend on current node's outputs
            nodes.filter { it.inputs.any { input -> input in node.outputs } }
        }
        fun visit(node: Node) {
            when {
                complete.contains(node) -> {
                    return
                }
                visited.contains(node) -> {
                    throw IllegalStateException("Cycle detected in computation graph")
                }
            }

            visited.add(node)

            // visit each neighbor of node
            nodeNeighbors[node]?.forEach { neighbor ->
                // null indicates computation dead-end
//                keyNodeMap[outputId]?.let { visit(it) }
                visit(neighbor)
            }
            visited.remove(node)
            complete.add(node)

            result.add(node)
        }
        // determine input nodes
        val outputIds = nodes.flatMap { it.outputs }.toSet()
        val inputs = nodes.filter { it.inputs.all { input -> input != outputIds }}

        // for each input node, visit the node
        inputs.forEach { input ->
            visit(input)
        }

        // return result in reversed order
        result.reverse()
        result
    }

    fun compute(context: ComputationContext) {
        computeOrder.forEach { node ->
            node.compute(context)
        }
    }

    /**
     * A computation node represents an operation in the computation graph.
     *
     * Nodes can have multiple inputs and many outputs. Edges are
     * represented as adjacency lists on each node: [inputs] and [outputEdges].
     */
    interface Node {

        /**
         * Values that this node depends on to compute its output(s).
         */
        val inputs: Set<ComputationKey<*>>

        /**
         * Values that this node produces as output.
         */
        val outputs: Set<ComputationKey<*>>

        /**
         * Computes the output value of the node in terms of its inputs.
         */
        fun compute(context: ComputationContext)
    }
}

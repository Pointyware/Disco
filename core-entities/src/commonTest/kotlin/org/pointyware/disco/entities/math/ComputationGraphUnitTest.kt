/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.entities.math

import org.pointyware.disco.entities.ExperimentalNetworkApi
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalNetworkApi::class)
class ComputationGraphUnitTest {

    @BeforeTest
    fun setUp() {

    }

    @AfterTest
    fun tearDown() {

    }

    @Test
    fun computation_order_uses_topological_sorting() {
        /*
        Given: a graph with nodes and edges
            Nodes: alpha, beta, gamma, delta, epsilon, zetta
            Edges: (alpha, beta), (beta, gamma), (beta, epsilon), (gamma, delta),
                   (delta, epsilon), (epsilon, zetta),(delta, zetta), (epsilon, zetta)
         */
        val alpha = IdProvider.getNextId().key<Int>()
        val beta = IdProvider.getNextId().key<Int>()
        val gamma = IdProvider.getNextId().key<Int>()
        val delta = IdProvider.getNextId().key<Int>()
        val epsilon = IdProvider.getNextId().key<Int>()
        val zetta = IdProvider.getNextId().key<Int>()

//        val alphaNode = Exists implicitly in computation context
        val betaNode = AdditionNode(setOf(alpha), beta)
        val gammaNode = AdditionNode(setOf(beta), gamma)
        val deltaNode = AdditionNode(setOf(gamma), delta)
        val epsilonNode = AdditionNode(setOf(beta, gamma), epsilon)
        val zettaNode = AdditionNode(setOf(delta, epsilon), zetta)

        val graph = ComputationGraph(
            nodes = setOf(
                betaNode, gammaNode, epsilonNode, deltaNode, zettaNode
            )
        )

        val expectedOrder = listOf(
            betaNode, gammaNode, deltaNode, epsilonNode, zettaNode
        )
        assertEquals(expectedOrder, graph.computeOrder)
    }
}

/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.entities.networks

import org.pointyware.disco.entities.ExperimentalNetworkApi
import org.pointyware.disco.entities.activations.ReLU
import org.pointyware.disco.entities.layers.DenseLayer
import org.pointyware.disco.entities.math.ComputationContext
import org.pointyware.disco.entities.math.IdProvider
import org.pointyware.disco.entities.math.key
import org.pointyware.disco.entities.tensors.Tensor
import kotlin.experimental.ExperimentalNativeApi
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertContentEquals

/**
 * Unit tests for inference through computation graph.
 */
@OptIn(ExperimentalNativeApi::class, ExperimentalNetworkApi::class)
class ComputationGraphUnitTest {

    private var inputKey = IdProvider.getNextId().key<Tensor>()
    private var outputKey = IdProvider.getNextId().key<Tensor>()

    @BeforeTest
    fun setUp() {

    }

    @AfterTest
    fun tearDown() {

    }

    @Test
    fun testInference() {
        val layer1 = DenseLayer(
            weights = Tensor.Companion.zeros(2, 3).apply {
                this[0, 0] = 2.0f
                this[0, 1] = 3.0f
                this[0, 2] = 5.0f
                this[1, 0] = 7.0f
                this[1, 1] = 11.0f
                this[1, 2] = 13.0f
            },
            biases = Tensor.Companion.zeros(2, 1).apply {
                this[0, 0] = 17.0f
                this[1, 0] = 19.0f
            },
            activationFunction = ReLU
        )
        val layer2 = DenseLayer(
            weights = Tensor.Companion.zeros(1, 2).apply {
                this[0, 0] = 23.0f
                this[0, 1] = 27.0f
            },
            biases = Tensor.Companion.zeros(1, 1).apply {
                this[0, 0] = 29.0f
            },
            activationFunction = ReLU
        )
        val network = SequentialNetwork(listOf(layer1, layer2))
        val input = Tensor.Companion.zeros(3, 1).apply {
            this[0] = 2.0f
            this[1] = 3.0f
            this[2] = 5.0f
        }
        val graph = network.graph
        val computationContext = ComputationContext()
        computationContext.put(inputKey, input)
        graph.compute(computationContext)
        val output = computationContext.get(outputKey)

        // The output should be a tensor of shape (1, 1) since the last layer has 1 output neuron
        assert(output.dimensions.contentEquals(intArrayOf(1, 1))) { "Output shape should be (1, 1), but was ${output.shapeString}" }

        val layer1Output = Tensor.Companion.zeros(2, 1).apply {
            this[0, 0] = 2.0f * 2.0f +  3.0f * 3.0f +  5.0f * 5.0f + 17.0f
            this[1, 0] = 7.0f * 2.0f + 11.0f * 3.0f + 13.0f * 5.0f + 19.0f
        }
        val expected = Tensor.Companion.zeros(1, 1).apply {
            this[0, 0] =
                layer1Output[0, 0] * 23.0f + layer1Output[1, 0] * 27.0f + 29.0f
        }
        assertContentEquals(expected.data, output.data)
    }
}

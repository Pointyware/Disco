/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.entities.networks

import org.pointyware.disco.entities.ExperimentalNetworkApi
import org.pointyware.disco.entities.math.ComputationGraph
import org.pointyware.disco.entities.math.key
import org.pointyware.disco.entities.tensors.Tensor

/**
 * A network is a collection of neurons that can be arranged in a wide variety of ways. Most often
 * they are arranged in layers, but they can also be arranged in more complex structures with
 * branches, skips, and other connections.
 *
 * A network's inputs can always be identified by `0L.key<InputType>()` and
 * outputs by `Long.MAX_VALUE.key<OutputType>()`.
 */
interface Network {
    val parameterCount: Int

    /**
     * Returns the computation graph of the network.
     */
    @ExperimentalNetworkApi
    val graph: ComputationGraph

    /**
     * Takes the input and performs a forward pass through the network, returning the output
     * as a [Tensor].
     */
    fun predict(input: Tensor): Tensor

    /**
     * Takes the input and performs a forward pass through the network, using the given
     * [activation] and [derivativeActivation] tensor lists to store the results.
     */
    fun forward(input: Tensor, activations: List<Tensor>, derivativeActivations: List<Tensor>)

    /**
     * Takes the gradient of the loss function given as [error], computing the gradients
     * and using the given [weightGradients] and [biasGradients] lists to store the results.
     */
    fun backward(
        input: Tensor,
        error: Tensor,
        activations: List<Tensor>,
        derivativeActivations: List<Tensor>,
        weightGradients: List<Tensor>,
        biasGradients: List<Tensor>
    )
}

inline fun <reified T: Any> inputKey() = 0L.key<T>()
inline fun <reified T: Any> outputKey() = Long.MAX_VALUE.key<T>()

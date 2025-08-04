/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.entities.blocks

import org.pointyware.disco.entities.ExperimentalNetworkApi
import org.pointyware.disco.entities.activations.SoftArgMax
import org.pointyware.disco.entities.math.ComputationGraph
import org.pointyware.disco.entities.tensors.Tensor
import kotlin.math.pow

/**
 *
 * - Scaled Dot Product Attention x Head Count (h)
 *   - MatMul Q and K
 *   - Scale by sqrt(d_k)
 *   - Optional Mask
 *   - SoftMax
 *   - MatMul SoftMax output with V
 *
 * @param dimensionKey The dimension of the key and query inputs.
 * @param dimensionValue The dimension of the value input.
 * @param mask An optional mask to apply to the attention scores.
 */
class ScaledDotProductAttention(
    val dimensionKey: Int,
    val dimensionValue: Int,
    val mask: Tensor? = null
): Attention {
    private val softmax = SoftArgMax()
    override val parameterCount: Int
        get() = softmax.parameterCount

    private val scalingFactor = dimensionKey.toDouble().pow(-0.5).toFloat()
    override fun calculate(query: Tensor, key: Tensor, value: Tensor): Tensor {
        val matMul = query.matrixMultiply(key)
        matMul.mapEach { it * scalingFactor }
        if (mask != null) {
            matMul.mapEachFlatIndexed { index, value -> value * mask[index] }
        }
        val softmax = softmax.calculate(matMul)
        return softmax.matrixMultiply(value)
    }

    @ExperimentalNetworkApi
    override val graph: ComputationGraph
        get() = TODO("Not yet implemented")
}

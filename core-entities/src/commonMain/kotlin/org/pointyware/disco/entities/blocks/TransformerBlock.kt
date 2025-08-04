/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.entities.blocks

import org.pointyware.disco.entities.ExperimentalNetworkApi
import org.pointyware.disco.entities.math.ComputationGraph
import org.pointyware.disco.entities.tensors.Tensor

/**
 * Based on the original paper: "Attention Is All You Need" https://arxiv.org/pdf/1706.03762
 *
 * The original transformer is composed of the following units, where StackCount = 6:
 * - Positional Encoding Summed with Input Embedding = I
 * - Encoder x StackCount = E_o
 *   - Multi-Head Attention = MHA_e
 *   - SumLayer (I, MHA_e) + Norm = N_e1
 *   - Feed Forward = FF_e
 *     - DenseLayer + ReLU
 *     - DenseLayer
 *   - SumLayer (N_e1 + FF_e) + Norm
 * - Positional Encoding Summed with Output Embedding = O
 * - Decoder x StackCount
 *   - Masked Multi-Head Attention (O, O, O) = MMHA
 *   - SumLayer (MMHA + O) + Norm = N_d1
 *   - Multi-Head Attention (E_o, E_o, N) = MHA_d
 *   - SumLayer (N_d1, MHA_d) + Norm = N_d2
 *   - Feed Forward = FF_d
 *     - DenseLayer + ReLU
 *     - DenseLayer
 *   - SumLayer (N_d2, FF_d) + Norm = N_d3
 * - Linear Layer
 * - Softmax Layer
 *
 * @see ScaledDotProductAttention
 * @see MultiHeadAttention
 */
class TransformerBlock(
    private val stackCount: Int,
): Block {

    private val encoders: List<Encoder> = List(stackCount) {
        Encoder()
    }

    private val decoders: List<Decoder> = List(stackCount) {
        Decoder()
    }

    override val parameterCount: Int
        get() = encoders.sumOf { it.parameterCount } + decoders.sumOf { it.parameterCount }

    fun calculate(input: Tensor, shiftedOutputs: Tensor): Tensor {
        var encoderOutput: Tensor = input
        for (index in 0 until stackCount) {
            val encoder = encoders[index]
            encoderOutput = encoder.calculate(encoderOutput)
        }

        var decoderOutput: Tensor = shiftedOutputs
        for (index in 0 until stackCount) {
            val decoder = decoders[index]
            decoderOutput = decoder.calculate(decoderOutput, encoderOutput)
        }
        return decoderOutput
    }

    @ExperimentalNetworkApi
    override val graph: ComputationGraph
        get() = TODO("Not yet implemented")

    inner class Encoder(
        // positionalEncoding
    ): Block {
        override val parameterCount: Int get() = 0 // TODO: replace when implemented
        fun calculate(input: Tensor): Tensor {
            TODO("Implement as documented above")
        }

        @ExperimentalNetworkApi
        override val graph: ComputationGraph
            get() = TODO("Not yet implemented")
    }

    inner class Decoder(
        // positionalEncoding
    ): Block {
        override val parameterCount: Int get() = 0 // TODO: replace when implemented
        fun calculate(input: Tensor, encoderOutput: Tensor): Tensor {
            TODO("Implement as documented above")
        }

        @ExperimentalNetworkApi
        override val graph: ComputationGraph
            get() = TODO("Not yet implemented")
    }
}

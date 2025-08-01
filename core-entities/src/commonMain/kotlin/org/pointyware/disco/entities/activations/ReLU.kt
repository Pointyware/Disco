/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.entities.activations

/**
 * Rectified Linear Unit (ReLU) activation function.
 */
object ReLU: ScalarActivationFunction {
    override val parameterCount: Int
        get() = 0

    override fun scalarActivation(input: Float): Float {
        return if (input > 0) input else 0.0f
    }

    override fun scalarDerivative(input: Float): Float {
        return if (input > 0) 1.0f else 0.0f
    }
}

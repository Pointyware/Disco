/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.entities.activations

import kotlin.math.pow
import kotlin.math.tanh

/**
 * Calculates the hyperbolic tangent of the input value.
 */
object Tanh: ScalarActivationFunction {
    override val parameterCount: Int
        get() = 0

    override fun scalarActivation(input: Float): Float {
        return tanh(input)
    }

    override fun scalarDerivative(input: Float): Float {
        return 1 - tanh(input).pow(2)
    }
}

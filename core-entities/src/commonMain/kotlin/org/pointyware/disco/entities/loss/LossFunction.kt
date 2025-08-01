/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.entities.loss

import org.pointyware.disco.entities.tensors.Tensor

/**
 * A loss function computes the error between the predicted output and the target output.
 */
interface LossFunction {
    fun compute(expected: Tensor, actual: Tensor): Double

    /**
     * Calculates the derivative of the loss function with respect to the actual output.
     *
     * Conceptually the same as the gradient of the loss function.
     */
    fun derivative(expected: Tensor, actual: Tensor): Tensor

    /**
     * Calculates the loss value and its derivative for the given expected and actual tensors,
     * and stores the derivative in the provided [derivative] tensor and returns the loss value.
     *
     * This is more efficient for optimizers that need both the loss value and the gradient.
     */
    fun computeAndDerivative(expected: Tensor, actual: Tensor, derivative: Tensor): Double // TODO: rename computeWithDerivative
}

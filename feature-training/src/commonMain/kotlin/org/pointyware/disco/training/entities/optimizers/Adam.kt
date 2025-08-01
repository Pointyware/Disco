/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.training.entities.optimizers

import org.pointyware.disco.entities.layers.Layer
import org.pointyware.disco.entities.tensors.Tensor
import org.pointyware.disco.training.entities.Exercise
import org.pointyware.disco.training.entities.Statistics

/**
 * Adam optimizer.
 * Based on research paper: https://arxiv.org/pdf/1412.6980
 */
data class Adam(
    val alpha: Double = 0.001,
    val beta1: Double = 0.9,
    val beta2: Double = 0.999,
    val epsilon: Double = 1e-8,
    val statistics: Statistics
): MultiPassOptimizer, Statistics by statistics {
    // TODO: allow multiple passes over samples
    override fun batch(cases: List<Exercise>): List<List<Exercise>> {
        TODO("Not yet implemented")
    }

    override fun update(step: Int, epoch: Int, layer: Layer, weightGradients: Tensor, biasGradients: Tensor) {
        TODO("Not yet implemented")
    }

    override fun passAgain(): Boolean {
        TODO("Not yet implemented")
    }
}

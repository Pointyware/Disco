/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.training.entities.optimizers

import org.pointyware.disco.entities.layers.Layer
import org.pointyware.disco.entities.tensors.Tensor
import org.pointyware.disco.training.entities.Exercise

/**
 * Implemented per lecture slides: https://www.cs.toronto.edu/~tijmen/csc321/slides/lecture_slides_lec6.pdf
 */
class RmsProp(

): SinglePassOptimizer {
    override fun batch(cases: List<Exercise>): List<List<Exercise>> {
        TODO("Not yet implemented")
    }

    override fun update(epoch: Int, layer: Layer, weightGradients: Tensor, biasGradients: Tensor) {
        TODO("Not yet implemented")
    }
}

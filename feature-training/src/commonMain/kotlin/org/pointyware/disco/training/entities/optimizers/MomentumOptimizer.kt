/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.training.entities.optimizers

import org.pointyware.disco.entities.DataList
import org.pointyware.disco.entities.layers.Layer
import org.pointyware.disco.entities.tensors.Tensor
import org.pointyware.disco.training.entities.BatchStatistics
import org.pointyware.disco.entities.math.ComputationContext
import org.pointyware.disco.training.entities.EpochStatistics
import org.pointyware.disco.training.entities.Exercise
import org.pointyware.disco.training.entities.Measurement
import org.pointyware.disco.training.entities.SampleStatistics
import org.pointyware.disco.training.entities.Snapshot

class MomentumOptimizer(
): SinglePassOptimizer, EpochStatistics, BatchStatistics, SampleStatistics {
    override val measurements: List<Measurement<Float>>
        get() = TODO("Not yet implemented")

    override fun measurementMaximum(key: Measurement<Float>): Float {
        TODO("Not yet implemented")
    }

    override val measurementsMax: Float
        get() = TODO("Not yet implemented")
    override val epochCount: Int
        get() = TODO("Not yet implemented")

    override fun createSnapshot(): Snapshot {
        TODO("Not yet implemented")
    }

    override fun data(key: Measurement<Float>): DataList<Float, Float> {
        TODO("Not yet implemented")
    }
    override fun onEpochStart(epoch: Int, context: ComputationContext) {
        TODO("Not yet implemented")
    }

    override fun onBatchStart(batch: List<Exercise>) {
        TODO("Not yet implemented")
    }

    override fun onSampleStart(sample: Exercise) {
        TODO("Not yet implemented")
    }

    override fun onCost(cost: Double) {
        TODO("Not yet implemented")
    }

    override fun onGradient() {
        TODO("Not yet implemented")
    }

    override fun onSampleEnd(sample: Exercise) {
        TODO("Not yet implemented")
    }

    override fun onBatchEnd(batch: List<Exercise>) {
        TODO("Not yet implemented")
    }

    override fun onEpochEnd(epoch: Int, context: ComputationContext) {
        TODO("Not yet implemented")
    }

    override fun batch(cases: List<Exercise>): List<List<Exercise>> {
        TODO("Not yet implemented")
    }

    override fun update(epoch: Int, layer: Layer, weightGradients: Tensor, biasGradients: Tensor) {
        TODO("Not yet implemented")
    }
}

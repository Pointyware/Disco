/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.training.data

import org.pointyware.disco.entities.tensors.Tensor
import org.pointyware.disco.entities.tensors.columnVector
import org.pointyware.disco.training.entities.Exercise
import kotlin.random.Random

/**
 *
 */
class XorExerciseGenerator(
    val problem: Problem.XorProblem
): ExerciseGenerator {
    override fun generate(): List<Exercise> {
        val inputs = listOf(
            columnVector(0.0f, 0.0f),
            columnVector(0.0f, 1.0f),
            columnVector(1.0f, 0.0f),
            columnVector(1.0f, 1.0f),
        )
        val targets = listOf(
            columnVector(0.0f),
            columnVector(1.0f),
            columnVector(1.0f),
            columnVector(0.0f),
        )
        return List(problem.setCount * 4) { index ->
            val source = inputs[index % 4]
            val target = targets[index % 4]
            if (problem.noise > 0) {
                val noisySource = Tensor(source.dimensions)
                noisySource.mapEachFlatIndexed { index, value ->
                    source[index] + problem.noise * (Random.Default.nextFloat() - 0.5f)
                }
                Exercise(
                    input = noisySource,
                    output = target
                )
            } else {
                Exercise(
                    input = source,
                    output = target
                )
            }
        }
    }
}

/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.training.data

import org.pointyware.disco.entities.tensors.columnVector
import org.pointyware.disco.training.entities.Exercise
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
import kotlin.random.Random

/**
 * Generates a batch of spiral classification exercises.
 */
class SpiralExerciseGenerator(
    val problem: Problem.SpiralClassificationProblem,
    val batchSize: Int = 50,
): ExerciseGenerator {
    override fun generate(): List<Exercise> {
        return List(batchSize) { index ->
            val classId = index % 2
            val phaseOffset = if (classId == 0) {
                0.0
            } else {
                PI
            }
            val t = Random.Default.nextFloat()
            val theta = 2 * PI * t * problem.spiralCount + phaseOffset
            val x = t * cos(theta) * problem.xMagnitude
            val y = t * sin(theta) * problem.yMagnitude
            Exercise(
                input = columnVector(x.toFloat(), y.toFloat()),
                output = columnVector(classId.toFloat()),
            )
        }
    }
}

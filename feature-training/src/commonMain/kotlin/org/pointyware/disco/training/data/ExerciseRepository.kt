/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.training.data

import org.pointyware.disco.training.entities.Exercise

/**
 * Provides [org.pointyware.disco.training.entities.Exercise] instances
 */
interface ExerciseRepository {
    fun getExercises(problem: Problem): List<Exercise>
}

/**
 *
 */
class ExerciseRepositoryImpl(

): ExerciseRepository {

    override fun getExercises(problem: Problem): List<Exercise> {
        return when (problem) {
            is Problem.XorProblem -> XorExerciseGenerator(problem).generate()
            is Problem.SpiralClassificationProblem -> SpiralExerciseGenerator(problem).generate()
        }
    }
}

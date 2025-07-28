package org.pointyware.disco.training.data

import org.pointyware.disco.training.entities.Exercise

/**
 * Generates lists of exercises for use in training against specific problems.
 */
interface ExerciseGenerator {
    fun generate(): List<Exercise>
}

/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.training.data

import org.pointyware.disco.training.entities.Exercise

/**
 * Generates lists of exercises for use in training against specific problems.
 */
interface ExerciseGenerator {
    fun generate(): List<Exercise>
}

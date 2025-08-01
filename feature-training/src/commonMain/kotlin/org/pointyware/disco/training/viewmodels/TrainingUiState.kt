/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.training.viewmodels


/**
 * Represents the state for all networks currently being trained.
 */
data class TrainingUiState(
    val isTraining: Boolean,
    val epochsRemaining: Int,
    val epochsElapsed: Int,
    val networks: List<NetworkTrainingUiState>
) {
    companion object {
        val Default = TrainingUiState(
            isTraining = false,
            epochsRemaining = 0,
            epochsElapsed = 0,
            networks = emptyList()
        )
    }
}

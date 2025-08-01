/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.training.viewmodels

import org.pointyware.disco.viewmodels.NeuralNetworkUiState

/**
 * Represents the state of a single network during training.
 *
 * @param epochsTrained The current epoch number in the training process. 0 indicates no
 * elapsed epochs.
 */
data class NetworkTrainingUiState(
    val epochsTrained: Int,
    val networkState: NeuralNetworkUiState,
    val statistics: StatisticsUiState
) {
    companion object {
        val Empty = NetworkTrainingUiState(
            epochsTrained = 0,
            networkState = NeuralNetworkUiState(),
            statistics = StatisticsUiState.Default
        )
    }
}

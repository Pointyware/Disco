/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.training.viewmodels

import org.pointyware.disco.ui.graph.DataSeries

/**
 * Represents the statistics collected during training.
 */
data class StatisticsUiState(
    val epochCount: Int,
    val floor: Float,
    val ceiling: Float,
    val data: List<DataSeries>
) {
    companion object {
        val Default = StatisticsUiState(
            epochCount = 10,
            floor = 0f,
            ceiling = 10f,
            data = emptyList()
        )
    }
}

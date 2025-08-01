/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.ui.graph

import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.text.TextMeasurer


/**
 *
 */
data class LineGraphState(
    val graphState: GraphState,
    val series: List<DataSeries>,
)

/**
 *
 */
fun DrawScope.drawLineGraph(
    state: LineGraphState,
    textMeasurer: TextMeasurer
) {
    drawGraph(
        state = state.graphState,
        textMeasurer = textMeasurer
    ) {
        state.series.forEach { series ->
            plotSeries(series.dataPoints.toList())
        }
    }
}

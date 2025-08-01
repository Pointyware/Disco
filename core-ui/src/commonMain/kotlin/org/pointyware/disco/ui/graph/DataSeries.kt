/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.ui.graph

import org.pointyware.disco.entities.DataList

/**
 * A single series of data points to be plotted on a graph.
 *
 * @see [drawLineGraph]
 * @see [drawScatterPlot]
 */
data class DataSeries(
    val label: String,
    val color: Long,
    val dataPoints: Map<Float, Float>,
)

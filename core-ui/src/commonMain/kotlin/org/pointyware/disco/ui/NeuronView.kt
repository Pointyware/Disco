/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import org.pointyware.disco.viewmodels.ColorMap
import org.pointyware.disco.viewmodels.DefaultColorMap

/**
 * Displays a single neuron in a neural network layer.
 * The neuron is represented by its weights and bias
 * rendered as colored squares.
 */
@Composable
fun NeuronView(
    weights: List<Float>,
    bias: Float,
    modifier: Modifier = Modifier,
    squareSize: Float = 20f,
    biasGap: Float = 2f,
    colorMap: ColorMap = DefaultColorMap
) {
    val density = LocalDensity.current
    val drawSize = remember(density) {
        squareSize * density.density
    }
    Canvas(
        modifier = modifier
            .width(((weights.size + 1) * squareSize + biasGap).dp) // Adjust width based on number of weights
            .height(squareSize.dp) // Fixed height for the neuron view
    ) {
        fun drawSquare(value: Float, offset: Float) {
            val color = colorMap.getColor(value)
            drawRect(
                color = color,
                topLeft = Offset(offset, 0f),
                size = Size(drawSize, drawSize)
            )
        }
        // Draw each weight as a colored square
        weights.forEachIndexed { index, weight ->
            drawSquare(weight, index * drawSize)
        }
        drawSquare(bias, weights.size * drawSize + biasGap * density.density)
    }
}

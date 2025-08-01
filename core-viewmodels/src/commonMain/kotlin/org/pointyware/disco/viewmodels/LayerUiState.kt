/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.viewmodels

import org.pointyware.disco.entities.activations.ActivationFunction

data class LayerUiState(
    val weights: List<List<Float>>,
    val biases: List<Float>,
    val activationFunction: ActivationFunction,
    val colorMap: ColorMap,
)

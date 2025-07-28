package org.pointyware.disco.viewmodels

import org.pointyware.disco.entities.activations.ActivationFunction

data class LayerUiState(
    val weights: List<List<Float>>,
    val biases: List<Float>,
    val activationFunction: ActivationFunction,
    val colorMap: ColorMap,
)

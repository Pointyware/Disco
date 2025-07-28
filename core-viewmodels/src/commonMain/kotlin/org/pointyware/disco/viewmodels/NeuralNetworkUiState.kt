package org.pointyware.disco.viewmodels

data class NeuralNetworkUiState(
    val layers: List<LayerUiState> = emptyList(),
    val parameters: Map<String, Any> = emptyMap()
)

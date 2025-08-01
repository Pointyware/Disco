/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.viewmodels

data class NeuralNetworkUiState(
    val layers: List<LayerUiState> = emptyList(),
    val parameters: Map<String, Any> = emptyMap()
)

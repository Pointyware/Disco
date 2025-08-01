/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.viewmodels

/**
 *
 */
sealed interface LoadingUiState {
    data object Idle: LoadingUiState
    data object Loading : LoadingUiState
    data class Error(val message: String) : LoadingUiState
}

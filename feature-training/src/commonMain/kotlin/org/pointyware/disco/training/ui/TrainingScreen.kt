/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.training.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.pointyware.disco.training.viewmodels.TrainingViewModel

/**
 * The Training Screen
 */
@Composable
fun TrainingScreen(
    viewModel: TrainingViewModel,
) {
    val state by viewModel.state.collectAsState()
    TrainingView(
        state = state,
        onStart = viewModel::onStart,
        onStop = viewModel::onStop,
        onReset = viewModel::onReset,
        onRun = viewModel::onRun,
    )
}

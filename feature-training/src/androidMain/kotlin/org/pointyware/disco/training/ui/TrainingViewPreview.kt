package org.pointyware.disco.training.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.pointyware.disco.entities.activations.ReLU
import org.pointyware.disco.training.viewmodels.NetworkTrainingUiState
import org.pointyware.disco.training.viewmodels.StatisticsUiState
import org.pointyware.disco.training.viewmodels.TrainingUiState
import org.pointyware.disco.ui.theme.DiscoTheme
import org.pointyware.disco.viewmodels.DefaultColorMap
import org.pointyware.disco.viewmodels.LayerUiState
import org.pointyware.disco.viewmodels.NeuralNetworkUiState

@Preview
@Composable
private fun TrainingViewPreview() {
    val colorMap = DefaultColorMap
    DiscoTheme {
        TrainingView(
            state = TrainingUiState(
                isTraining = false,
                epochsElapsed = 10,
                epochsRemaining = 20,
                networks = listOf(
                    NetworkTrainingUiState(
                        epochsTrained = 10,
                    NeuralNetworkUiState(
                            layers = listOf(
                                LayerUiState(
                                    activationFunction = ReLU,
                                    weights = listOf(
                                        listOf(0.1f, 0.2f),
                                        listOf(-0.3f, 0.4f),
                                        listOf(0.5f, 0.6f)
                                    ),
                                    biases = listOf(0.1f, -0.2f, 0.3f),
                                    colorMap = colorMap
                                ),
                                LayerUiState(
                                    activationFunction = ReLU,
                                    weights = listOf(
                                        listOf(-0.7f, 0.8f),
                                        listOf(-0.1f, -0.2f)
                                    ),
                                    biases = listOf(0.1f, 0.2f),
                                    colorMap = colorMap
                                )
                            )
                        ),
                        statistics = StatisticsUiState(
                            epochCount = 10,
                            floor = 0f,
                            ceiling = 0.5f,
                            data = emptyList()
                        )
                    )
                ),
            ),
            onStart = {},
            onStop = {},
            onReset = {},
            onRun = {},
        )
    }
}

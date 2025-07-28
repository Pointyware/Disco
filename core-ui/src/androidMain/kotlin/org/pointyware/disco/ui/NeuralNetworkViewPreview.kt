package org.pointyware.disco.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.pointyware.disco.entities.activations.ReLU
import org.pointyware.disco.entities.activations.Logistic
import org.pointyware.disco.ui.theme.DiscoTheme
import org.pointyware.disco.viewmodels.CenteredColorMap
import org.pointyware.disco.viewmodels.LayerUiState
import org.pointyware.disco.viewmodels.NeuralNetworkUiState

@Preview
@Composable
private fun NeuralNetworkViewPreview() {
    val consistentScale = CenteredColorMap(
        magnitudeClip = 0.7f,
    )
    DiscoTheme {
        NeuralNetworkView(
            state = NeuralNetworkUiState(
                layers = listOf(
                    LayerUiState(
                        activationFunction = ReLU,
                        weights = listOf(
                            listOf(0.1f, 0.2f, 0.5f),
                            listOf(-0.3f, 0.4f, -0.6f),
                            listOf(0.5f, 0.6f, 0.7f)
                        ),
                        biases = listOf(0.1f, -0.2f, 0.3f),
                        colorMap = consistentScale,
                    ),
                    LayerUiState(
                        activationFunction = Logistic,
                        weights = listOf(
                            listOf(-0.7f, 0.8f),
                            listOf(-0.1f, -0.2f)
                        ),
                        biases = listOf(0.1f, 0.2f),
                        colorMap = consistentScale,
                    ),
                    LayerUiState(
                        activationFunction = Logistic,
                        weights = listOf(
                            listOf(-0.7f, 0.8f),
                            listOf(-0.1f, -0.2f)
                        ),
                        biases = listOf(0.1f, 0.2f),
                        colorMap = consistentScale,
                    )
                ),
            )
        )
    }
}

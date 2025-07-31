# Disco
This project started as a small attempt to recreate some machine learning primitives from 
scratch in Kotlin.
I quickly realized while doing research that I could fairly easily build a small set of primitives
to build larger components and scale up complexity rapidly. At the same time that I was
learning about different optimization and visualization techniques for my own use, I realized
they would make fantastic learning tools for others as well.

Related: https://github.com/Pointyware/AI-Licensing

## ML Primitives

| Category             | Name                          | Description                                                                                                     |
|----------------------|-------------------------------|-----------------------------------------------------------------------------------------------------------------|
| Tensors              | Pools                         | Pools to store and reuse tensors by dimension                                                                   |
| Activation Functions | ReLU                          | Rectified Linear Unit                                                                                           |
|                      | Logistic                      | Often referred to as "the sigmoid"                                                                              |
|                      | Tanh                          | Hyperbolic tangent                                                                                              |
|                      | GELU†                         | Gaussian Error Linear Unit                                                                                      |
|                      | Swish†                        | Linear interpolation between linear and ReLU                                                                    |
|                      | SwiGLU†                       | Swish-based Gated Linear Unit                                                                                   |
| Regularizers         | RMSNorm                       | Normalizes each input by the root-mean-squared across all inputs                                                |
|                      | LayerNorm†                    |                                                                                                                 |
| Layers               | Dense                         | Linear (Fully Connected)                                                                                        |
|                      | Convolutional†                |                                                                                                                 |
| Networks             | Sequential Networks           | Networks composed entirely of layers, each receiving a single input from the previous layer                     |
|                      | Residual Networks             | Layer-based networks that allow skip connections                                                                |
| Cost/Loss Functions  | Mean Squared Error            |                                                                                                                 |
|                      | Cross Entropy Loss            | Converts the output predictions to                                                                              |
| Optimizers           | Gradient Descent              | Computes gradients across all samples before updating parameters.                                               |
|                      | Stochastic (Gradient Descent) | Computes gradients across stochastically selected samples before updating parameters.                           |
|                      | Adam†                         | Momentum-based; performs multiple passes over samples and parameter updates in a single epoch                   |
| Training             | Sequential Trainer            | Trainer for a Sequential Network                                                                                |
|                      | AutoDiff Trainer              | Trainer for any network that produces a computation graph.                                                      |
|                      | Organic Trainer†              | Trainer that modifies a network according to statistics; mimics neurogenesis and ablation at alternating stages |

† - Planned/Experimental

```mermaid
classDiagram
    class Tensor {
        dimensions: List~Int~
        get(indices: List~Int~): Double
    }
    class ActivationFunction {
        calculate(value: Double): Double
    }
    class Layer {
        weights: Tensor
        biases: Tensor
        activation: ActivationFunction
    }
    Layer *--> Tensor
    Layer *--> ActivationFunction

    note for Network "A neural network composed of neurons."
    class Network
    class SequentialNetwork {
        layers: List~Layer~
    }
    SequentialNetwork *--> "1..*" Layer
    Network <|-- SequentialNetwork

    class Loss {
        calculate(expected: Tensor, actual: Tensor): Double
    }
    note for Optimizer "An optimizer is responsible for <br>adjusting the weights and biases <br>of a layer based on the error <br>gradient."
    class Optimizer {
        batch()
        update()
    }

    class EpochStatistics {
        onEpochStart()
        onEpochEnd()
    }
    class BatchStatistics {
        onBatchStart()
        onBatchEnd()
    }
    class SampleStatistics {
        onSampleStart()
        onSampleEnd()
    }
    class LayerStatistics {
        onLayerStart()
        onLayerEnd()
    }
    class GradientDescent
    GradientDescent --|> Optimizer
    GradientDescent --|> SampleStatistics
    class StochasticGradientDescent
    StochasticGradientDescent --|> Optimizer
    StochasticGradientDescent --|> BatchStatistics
    class Adam
    Adam --|> Optimizer
    Adam --|> BatchStatistics

    note for StudyCase "A study case associates an <br>input with an expected output."
    class StudyCase {
        input: Tensor
        output: Tensor
    }

    note for SequentialTrainer "A trainer presents cases to <br>a network and tracks gradients <br>for back-propagation."
    class SequentialTrainer {
        network: SequentialNetwork
        cases: StudyCase
        lossFunction: Loss
        optimizer: Optimizer
    }
    SequentialTrainer *--> SequentialNetwork
    SequentialTrainer *--> "1.." StudyCase
    SequentialTrainer *--> Loss
    SequentialTrainer *--> Optimizer

    class LearningTensor
    class SimpleTensor
    Tensor <|-- LearningTensor
    Tensor <|-- SimpleTensor

    class ReLU
    class Sigmoid
    class Linear
    ActivationFunction <|-- ReLU
    ActivationFunction <|-- Sigmoid
    ActivationFunction <|-- Linear

    class MeanSquaredError {
    }
    Loss <|-- MeanSquaredError

    class StochasticGradientDescent {
    }
    Optimizer <|-- StochasticGradientDescent

```

## Project Structure

The structure of this project is based on Clean Architecture applied to Android's MVVM architecture.
UI and Data implementations occupy the outermost frameworks/drivers layer. ViewModels, 
Repository Implementations, Data Source interfaces and occupy the adapter/interfaces layer. 
Interactors and Repository interfaces occupy the application business layer.
Entities occupy the enterprise business layer.

```mermaid

graph
    subgraph apps
    :app-android --> :app-shared
    :app-desktop --> :app-shared
    end
    apps --> features

    subgraph features
    :feature-training --> :feature-simulation
    :feature-simulation-training --> :feature-simulation
    :feature-simulation-training --> :feature-training
    :feature-training
    :feature-evolution --> :feature-simulation
    end
    features --> core

    subgraph core
    :core-ui --> :core-viewmodels --> :core-interactors --> :core-data --> :core-entities --> :core-common
    end
```

## Research Citations
1. Ashish Vaswani, Noam Shazeer, Niki Parmar, Jakob Uszkoreit, Llion Jones, Aidan N. Gomez, Lukasz Kaiser, Illia Polosukhin. Attention is All You Need. *arXiv preprint arXiv:IDvN*, 2017
2. Ravid Schwartz-Ziv, Naftali Tishby. Opening the Black Box of Deep Neural Networks via Information. *arXiv preprint arXiv:1703.00810v3*, 2017.
3. 
4. Author, Author. Title. *Publication*, Year.

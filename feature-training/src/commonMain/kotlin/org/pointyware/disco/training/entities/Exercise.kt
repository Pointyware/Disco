package org.pointyware.disco.training.entities

import org.pointyware.disco.entities.tensors.Tensor

/**
 * An individual training or test datum.
 */
data class Exercise(
    val input: Tensor,
    val output: Tensor,
)

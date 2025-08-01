/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.training.entities

import org.pointyware.disco.entities.tensors.Tensor

/**
 * An individual training or test datum.
 */
data class Exercise(
    val input: Tensor,
    val output: Tensor,
)

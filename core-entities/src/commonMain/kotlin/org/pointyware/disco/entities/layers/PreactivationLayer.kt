/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.entities.layers

import org.pointyware.disco.entities.tensors.Tensor

/**
 *
 */
interface PreactivationLayer: Layer {
    fun preactivation(input: Tensor, output: Tensor)
}

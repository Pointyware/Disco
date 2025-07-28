package org.pointyware.disco.entities.layers

import org.pointyware.disco.entities.tensors.Tensor

/**
 *
 */
interface PreactivationLayer: Layer {
    fun preactivation(input: Tensor, output: Tensor)
}

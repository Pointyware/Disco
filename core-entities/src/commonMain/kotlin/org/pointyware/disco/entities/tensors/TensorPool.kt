/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.entities.tensors

import org.pointyware.disco.entities.ObjectPool

/**
 * A pool of [Tensor] instances. Each tensor is zeroed when it is returned to the pool.
 */
class TensorPool: ObjectPool<List<Int>, Tensor>() {
    override fun getKeyFromObject(obj: Tensor): List<Int> {
        return obj.dimensions.toList()
    }

    override fun createObject(key: List<Int>): Tensor {
        return Tensor(key.toIntArray())
    }

    override fun onReturn(obj: Tensor) {
        obj.zero()
    }
}

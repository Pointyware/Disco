/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.entities.tensors

class ListVector(
    val source: Tensor,
    val row: Int
): List<Float> {
    override val size: Int
        get() = source.dimensions[1]

    override fun contains(element: Float): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsAll(elements: Collection<Float>): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(index: Int): Float {
        TODO("Not yet implemented")
    }

    override fun indexOf(element: Float): Int {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun iterator(): Iterator<Float> {
        TODO("Not yet implemented")
    }

    override fun lastIndexOf(element: Float): Int {
        TODO("Not yet implemented")
    }

    override fun listIterator(): ListIterator<Float> {
        TODO("Not yet implemented")
    }

    override fun listIterator(index: Int): ListIterator<Float> {
        TODO("Not yet implemented")
    }

    override fun subList(fromIndex: Int, toIndex: Int): List<Float> {
        TODO("Not yet implemented")
    }
}

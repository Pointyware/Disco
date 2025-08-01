/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.entities.signals.derivatives

import org.pointyware.disco.entities.signals.Signal

/**
 * A series of related images, usually continuous, that depict visual information across time.
 */
interface Video: Signal.Derivative {
    val width: Int
    val height: Int
    // just for modeling; example of architecture disrupting efficiency
    fun getPixel(time: Float, x: Int, y: Int)
}

/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.entities.signals.derivatives

import org.pointyware.disco.entities.signals.Signal

/**
 * A sequence of signals corresponding to pressure waves.
 */
interface Audio<S:Number>: Signal.Derivative {
    /**
     * The individual pressure signals.
     */
    val waveform: Array<S>

    /**
     * The number of samples (signals) per second.
     */
    val sampleRate: Float
}

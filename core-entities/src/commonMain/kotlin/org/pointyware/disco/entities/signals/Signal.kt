/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.entities.signals

/**
 * An input or output type of some system.
 *
 * Short-term the focus will be on [Derivative] types
 *
 * Long-term I would like to support integration with systems that work with [Primitive] types and
 * use neural networks to derive higher order types.
 */
sealed interface Signal {

    /**
     * A complex signal type that would be organically derived from primitive sensory signals.
     */
    interface Derivative: Signal

    /**
     * A simple signal type that would be organically produced through sensory receptors.
     */
    interface Primitive: Signal
}

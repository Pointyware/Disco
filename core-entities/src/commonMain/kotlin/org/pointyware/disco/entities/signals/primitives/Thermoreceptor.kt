package org.pointyware.disco.entities.signals.primitives

import org.pointyware.disco.entities.signals.Signal

/**
 * Senses temperature.
 */
interface Thermoreceptor: Signal.Primitive {
    val temperature: Float
}

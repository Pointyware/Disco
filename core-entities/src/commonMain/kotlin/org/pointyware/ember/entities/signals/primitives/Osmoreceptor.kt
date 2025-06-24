package org.pointyware.ember.entities.signals.primitives

import org.pointyware.ember.entities.signals.Signal

/**
 * Detects osmotic pressure. Related to chemoreceptors but function more like mechanoreceptors:
 * changes is osmolality are detected through their structural effect on receptors.
 */
interface Osmoreceptor: Signal.Primitive {
    val pressure: Float
}

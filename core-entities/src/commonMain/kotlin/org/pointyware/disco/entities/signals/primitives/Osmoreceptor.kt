/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.entities.signals.primitives

import org.pointyware.disco.entities.signals.Signal

/**
 * Detects osmotic pressure. Related to chemoreceptors but function more like mechanoreceptors:
 * changes is osmolality are detected through their structural effect on receptors.
 */
interface Osmoreceptor: Signal.Primitive {
    val pressure: Float
}

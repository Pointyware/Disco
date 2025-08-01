/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.entities.signals.primitives

import org.pointyware.disco.entities.signals.Signal

/**
 * There are a massive variety of chemoreceptors. In general they sense chemical concentrations.
 * Specifically, they are responsible for sense of smell and taste as well as the ability to sense
 * blood
 */
interface Chemoreceptor<C>: Signal.Primitive {
    val chemicals: C
}

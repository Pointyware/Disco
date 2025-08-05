/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.entities.math

import org.pointyware.disco.entities.ExperimentalNetworkApi

/**
 * A component in a computation graph.
 */
interface ComputationComponent {
    /**
     * Returns the computation subgraph representing this component.
     */
    @ExperimentalNetworkApi
    val graph: ComputationGraph
}

/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.navigation

import kotlinx.serialization.Serializable

/**
 * Core navigation destinations.
 *
 * These are preferably exposed in a core-navigation module so that each feature can declare
 * its own destinations without needing to know about others except dependent features.
 *
 * These destinations are application-level logic and are distinct from the [TopLevelDestination]
 * which is a UI-specific implementation of controlling navigation.
 */
@Serializable
sealed interface Destination {
    @Serializable
    data class Lab(
        val networkId: String,
    ): Destination
}

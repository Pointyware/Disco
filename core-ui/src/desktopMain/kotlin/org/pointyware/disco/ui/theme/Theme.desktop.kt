/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import org.pointyware.disco.ui.theme.simpleColorScheme

@Composable
actual fun colorScheme(
    darkTheme: Boolean,
    dynamicTheme: Boolean
): ColorScheme {
    return simpleColorScheme(darkTheme)
}

package org.pointyware.disco.ui.theme

import androidx.compose.material3.ColorScheme

@androidx.compose.runtime.Composable
actual fun colorScheme(
    darkTheme: Boolean,
    dynamicTheme: Boolean
): ColorScheme {
    return simpleColorScheme(darkTheme)
}

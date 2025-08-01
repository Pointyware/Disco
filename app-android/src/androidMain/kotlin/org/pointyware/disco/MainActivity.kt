/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.pointyware.disco.ui.DiscoApp
import org.pointyware.disco.ui.theme.DiscoTheme

/**
 * Main entry-point for the Android application. We plan to follow the single-activity app model,
 * using the shared composables for the UIs, but we are not restricting ourselves from using other
 * Android components to extend the functionality of the app.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiscoTheme {
                DiscoApp()
            }
        }
    }
}

@Preview
@Composable
fun AndroidAppPreview() {
    DiscoTheme {
        DiscoApp()
    }
}

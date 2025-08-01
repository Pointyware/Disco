/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


/**
 *
 */
@Composable
fun CollapsibleColumn(
    header: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    isExpanded: Boolean = false,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        header()

        // TODO: animate collapse
        if (isExpanded) {
            content()
        }
    }
}

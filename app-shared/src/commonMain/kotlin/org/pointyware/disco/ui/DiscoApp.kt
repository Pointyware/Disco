/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.pointyware.disco.navigation.TopLevelDestination
import org.pointyware.disco.navigation.navigateTo

/**
 * The root for Compose UI.
 */
@Composable
fun DiscoApp() {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val selectedItem = backStackEntry?.destination
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        NavigationSuiteScaffold(
            modifier = Modifier.safeDrawingPadding(),
            navigationSuiteItems = {
                TopLevelDestination.entries.forEach {
                    item(
                        selected = selectedItem == it.destination,
                        onClick = {
                            navController.navigateTo(it)
                        },
                        icon = {
                            Icon(
                                painter = painterResource(it.iconRes),
                                contentDescription = stringResource(it.contentDescriptionRes)
                            )
                        },
                        label = { Text(text = stringResource(it.labelRes)) }
                    )
                }
            },
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        ) {
            DiscoNavigation(
                modifier = Modifier
                    .fillMaxSize(),
                navController = navController
            )
        }
    }
}

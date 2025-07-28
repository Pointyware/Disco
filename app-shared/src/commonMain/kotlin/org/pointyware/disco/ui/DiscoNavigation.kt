package org.pointyware.disco.ui

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.toRoute
import org.jetbrains.compose.resources.stringResource
import org.pointyware.disco.navigation.Destination
import org.pointyware.disco.training.ui.TrainingScreen
import org.pointyware.disco.training.viewmodels.TrainingViewModel
import org.pointyware.disco.ui.Res as UiRes


/**
 * Localizes navigation logic for the Agent and Service screens.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiscoNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    Column {
        val currentBackStack by navController.currentBackStackEntryAsState()
        TopAppBar(
            title = { Text(text = stringResource(UiRes.string.title_app)) },
            navigationIcon = {
                // nav graph is always the first entry
                if (currentBackStack?.destination?.id != navController.graph.startDestinationId) {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(UiRes.string.acc_desc_back)
                        )
                    }
                }
            }
        )
        NavHost(
            navController = navController,
            startDestination = Destination.Lab("replace_me"),
            modifier = modifier,
            enterTransition = {
                slideInVertically(
                    animationSpec = tween(300),
                    initialOffsetY = { it }
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(0),
                    targetAlpha = 1f
                )
            },
            popEnterTransition = {
                fadeIn(
                    animationSpec = tween(0),
                    initialAlpha = 1f
                )
            },
            popExitTransition = {
                slideOutVertically(
                    animationSpec = tween(300),
                    targetOffsetY = { it }
                )
            }
        ) {
            composable<Destination.Lab> {
                val route = it.toRoute<Destination.Lab>()
                val viewModel = rememberViewModel<TrainingViewModel>()
                LaunchedEffect(route) {
                    viewModel.loadNetwork(route.networkId)
                }
                TrainingScreen(
                    viewModel = viewModel
                )
            }
        }
    }
}

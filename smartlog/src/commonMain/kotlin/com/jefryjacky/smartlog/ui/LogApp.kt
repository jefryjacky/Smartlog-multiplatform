package com.jefryjacky.smartlog.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jefryjacky.smartlog.di.AppContainer
import com.jefryjacky.smartlog.ui.logs.LogContent
import com.jefryjacky.smartlog.ui.logs.LogViewModel

@Composable
fun LogApp(
    onNavHostReady: suspend (NavController) -> Unit = {}
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.LOGS.routename
    ) {
        composable(Route.LOGS.routename){
            val viewModel: LogViewModel = viewModel(factory = AppContainer.logViewModel)
            val state = viewModel.state.collectAsState().value
            LogContent(state)
        }
    }
    LaunchedEffect(navController) {
        onNavHostReady(navController)
    }
}
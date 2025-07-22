package com.jefryjacky.smartlog.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.toRoute
import com.jefryjacky.smartlog.di.AppContainer
import com.jefryjacky.smartlog.domain.entity.LogEntity
import com.jefryjacky.smartlog.ui.logdetail.LogDetailContent
import com.jefryjacky.smartlog.ui.logdetail.LogDetailViewModel
import com.jefryjacky.smartlog.ui.logs.LogContent
import com.jefryjacky.smartlog.ui.logs.LogEvent
import com.jefryjacky.smartlog.ui.logs.LogViewModel

@Composable
fun LogApp(
    onNavHostReady: suspend (NavController) -> Unit = {}
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.Logs
    ) {
        composable<Route.Logs>{
            val viewModel: LogViewModel = viewModel(factory = AppContainer.logViewModel)
            val state by viewModel.state.collectAsStateWithLifecycle()
            val filterBottomSheetState by viewModel.filterBottomSheet.collectAsStateWithLifecycle()
            LogContent(state, filterBottomState = filterBottomSheetState, event = {
                when(it){
                    is LogEvent.CardClickEvent -> {
                        navController.navigate(Route.LogDetail(it.id))
                    }
                    else -> {
                        viewModel.handleEvent(it)
                    }
                }
            }, filterEvent = {
                viewModel.handleFilterEvent(it)
            })
        }
        composable<Route.LogDetail> {
            val viewModel: LogDetailViewModel = viewModel(factory = AppContainer.logDetailViewModel)
            val detail: Route.LogDetail = it.toRoute()
            viewModel.id = detail.id
            val state by viewModel.state.collectAsStateWithLifecycle()
            LogDetailContent(state)
        }
    }
    LaunchedEffect(navController) {
        onNavHostReady(navController)
    }
}
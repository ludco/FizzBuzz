package com.app.fizzbuzz.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.app.fizzbuzz.model.GameInputs
import com.app.fizzbuzz.ui.screens.FormScreen
import com.app.fizzbuzz.ui.screens.ResultScreen

enum class AppScreens() {
    Form, Result
}


@Composable
fun FizzBuzzApp(gameViewModel: GameViewModel = viewModel(), navController: NavHostController = rememberNavController() ) {
    val gameUiState by gameViewModel.uiState.collectAsState()


    fun onPlayButtonClicked(gameInputs: GameInputs) {
        gameViewModel.getResult(gameInputs)
        navController.navigate(AppScreens.Result.name)
    }

    fun onPlayAgainButtonClicked() {
        gameViewModel.resetGame()
        navController.navigate(AppScreens.Form.name)
    }

    NavHost(navController = navController, startDestination = AppScreens.Form.name) {
        composable(route = AppScreens.Form.name) {
            FormScreen(
                onPlayButtonClicked = { onPlayButtonClicked(it) },
                gameViewModel = gameViewModel
            )
        }
        composable(route = AppScreens.Result.name) {
            ResultScreen(gameUiState) { onPlayAgainButtonClicked() }
        }
    }
}
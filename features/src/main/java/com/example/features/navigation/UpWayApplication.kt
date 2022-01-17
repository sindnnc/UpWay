package com.example.features.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.features.auth.login.ui.LoginUI
import com.example.features.auth.login.viewmodel.LoginViewModel
import com.example.features.auth.onboard.ui.OnBoardUI
import com.example.features.auth.splash.ui.SplashUI

@Composable
fun UpWayApplication() {
    val navController = rememberNavController()
    val configuration = LocalConfiguration.current

    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    NavHost(navController = navController, startDestination = Screens.SplashUI.route) {
        composable(route = Screens.SplashUI.route) {
            SplashUI(navController = navController)
        }
        composable(route = Screens.OnBoardUI.route) {
            OnBoardUI(
                navController = navController,
                screenWidth = screenWidth,
                screenHeight = screenHeight
            )
        }
        composable(route = Screens.LoginUI.route) {
            val loginViewModel = hiltViewModel<LoginViewModel>()
            LoginUI(
                navController = navController,
                viewModel = loginViewModel,
                screenWidth = screenWidth,
                screenHeight = screenHeight
            )
        }
    }
}
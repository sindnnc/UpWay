package com.example.features.presentation.auth.splash.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.example.features.navigation.Screens


@Composable
fun SplashUI(navController: NavController) {
    LaunchedEffect(Unit) {
        navController.navigate(Screens.OnBoardUI.route) {
            popUpTo(Screens.SplashUI.route) { inclusive = true }
        }
    }
}

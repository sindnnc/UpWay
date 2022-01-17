package com.example.features.navigation

sealed class Screens(val route: String) {
    object SplashUI : Screens("splash")
    object OnBoardUI : Screens("onboard")
    object LoginUI : Screens("login")
    object RegisterUI : Screens("register")
    object HomeUI : Screens("home")
}
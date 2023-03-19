package com.example.jetpackcompose.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.navigation.NavigationTree
import com.example.jetpackcompose.ui.screens.login.LoginScreen
import com.example.jetpackcompose.ui.screens.splash.SplashScreen

@Composable
fun ApplicationScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavigationTree.Splash.name) {
        composable(route = NavigationTree.Splash.name, content = { SplashScreen(navController) })
        composable(route = NavigationTree.Login.name) { LoginScreen(navController) }
    }
}
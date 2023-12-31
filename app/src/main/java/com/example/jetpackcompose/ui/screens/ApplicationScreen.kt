package com.example.jetpackcompose.ui.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.navigation.NavigationTree
import com.example.jetpackcompose.navigation.navigateToFeature2
import com.example.jetpackcompose.navigation.navigationFeature1
import com.example.jetpackcompose.navigation.navigationFeature2
import com.example.jetpackcompose.ui.screens.login.LoginScreen
import com.example.jetpackcompose.ui.screens.login.LoginViewModel
import com.example.jetpackcompose.ui.screens.screen1.AnimatedRopesScreen
import com.example.jetpackcompose.ui.screens.screen1.AnimationScreen
import com.example.jetpackcompose.ui.screens.screen1.Screen1
import com.example.jetpackcompose.ui.screens.screen1.Screen1ViewModel
import com.example.jetpackcompose.ui.screens.splash.SplashScreen

@Composable
fun ApplicationScreen() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavigationTree.Feature1Screen1.name
    ) {
        composable(route = NavigationTree.Splash.name, content = { SplashScreen(navController) })
        composable(route = NavigationTree.Login.name) {
            val loginViewModel = hiltViewModel<LoginViewModel>()
            LoginScreen(loginViewModel = loginViewModel)
        }
        composable(route = NavigationTree.Screen1.name) {
            val screen1ViewModel = hiltViewModel<Screen1ViewModel>()
            Screen1(screen1ViewModel)
        }
        composable(route = NavigationTree.AnimationBasic.name) {
            AnimationScreen()
        }
        composable(route = NavigationTree.AnimatedRopes.name) {
            AnimatedRopesScreen()
        }

        navigationFeature1(onButtonClick = navController::navigateToFeature2)
        //Construct a nested NavGraph
        navigationFeature2()

        //dialogs
        dialog(route = "dialogDestination") {}
    }
}
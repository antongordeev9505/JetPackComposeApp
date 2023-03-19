package com.example.jetpackcompose.ui.screens.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.example.jetpackcompose.navigation.NavigationTree

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(key1 = Unit, block = {
        navController.navigate(route = NavigationTree.Login.name)
    })
}
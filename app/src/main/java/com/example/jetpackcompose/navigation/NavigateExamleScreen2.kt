package com.example.jetpackcompose.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.jetpackcompose.ui.screens.NavigationExampleScreen2

fun NavGraphBuilder.navigationExampleScreen2() {
    composable(route = NavigationTree.NavigationExample2.name) {
        NavigationExampleScreen2()
    }
}

fun NavController.navigateToScreen2() {
    navigate(NavigationTree.NavigationExample2.name)
}
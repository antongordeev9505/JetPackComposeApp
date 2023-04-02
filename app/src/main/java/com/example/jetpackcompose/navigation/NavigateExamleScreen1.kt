package com.example.jetpackcompose.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.jetpackcompose.ui.screens.NavigationExampleScreen

fun NavGraphBuilder.navigationExampleScreen(onButtonClick: (first: String, second: String) -> Unit) {
    composable(route = NavigationTree.NavigationExample.name) {
        NavigationExampleScreen(onButtonClick = onButtonClick)
    }
}
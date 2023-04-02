package com.example.jetpackcompose.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.jetpackcompose.ui.screens.Feature1Screen1

fun NavGraphBuilder.navigationFeature1(onButtonClick: (first: String, second: String) -> Unit) {
    composable(route = NavigationTree.Feature1Screen1.name) {
        Feature1Screen1(onButtonClick = onButtonClick)
    }
}
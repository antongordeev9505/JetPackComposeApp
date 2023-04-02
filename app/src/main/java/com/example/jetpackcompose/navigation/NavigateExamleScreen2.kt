package com.example.jetpackcompose.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.jetpackcompose.ui.screens.NavigationExampleScreen2

private const val firstKey = "first"
private const val secondKey = "second"
private const val screen2Route = "NavigationExample2"
private const val screen2RouteWithArgs: String = "$screen2Route/{$firstKey}?second={$secondKey}"
//second is secondary arg
//first is primary arg

fun NavGraphBuilder.navigationExampleScreen2() {
    composable(
        route = screen2RouteWithArgs,
        arguments = listOf(
            navArgument(firstKey) {
                type = NavType.StringType
            },
            navArgument(secondKey) {
                type = NavType.StringType
                nullable = true
                defaultValue = null
            }
        )
    ) { navBackStackEntry ->
        val first = navBackStackEntry.arguments?.getString(firstKey) ?: ""
        val second = navBackStackEntry.arguments?.getString(secondKey).orEmpty()
        NavigationExampleScreen2(firstArg = first, secondArg = second)
    }
}

fun NavController.navigateToScreen2(first: String, second: String) {
    navigate("$screen2Route/$first?second=$second")
}
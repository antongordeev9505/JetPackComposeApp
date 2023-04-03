package com.example.jetpackcompose.navigation

import android.net.Uri
import androidx.navigation.NavController
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.example.jetpackcompose.ui.screens.Feature2Screen1
import com.example.jetpackcompose.ui.screens.Feature2Screen2

private const val firstKey = "first"
private const val secondKey = "second"
private const val screen2Route = "NavigationExample2"
private const val screen2RouteWithArgs: String = "$screen2Route/{$firstKey}?second={$secondKey}"
private const val feature2RouteWithArgs: String = "feature2/{$firstKey}?second={$secondKey}"
private const val DEEPLINK_SCHEME = "composeapp"
private const val BASE_ROUTE_SCREEN_2 = "Feature2Screen2"
//second is secondary arg
//first is primary arg

fun NavGraphBuilder.navigationFeature2() {
    navigation(
        route = feature2RouteWithArgs,
        arguments = listOf(
            navArgument(firstKey) {
                type = NavType.StringType
            },
            navArgument(secondKey) {
                type = NavType.StringType
                nullable = true
                defaultValue = null
            }
        ),
        deepLinks = listOf(NavDeepLink("$DEEPLINK_SCHEME://feature2/{$firstKey}")),
        startDestination = NavigationTree.Feature2Screen1.name
    ) {
        composable(route = NavigationTree.Feature2Screen1.name) { navBackStackEntry ->
            val firstEncoded = navBackStackEntry.arguments?.getString(firstKey) ?: ""
            val secondEncoded = navBackStackEntry.arguments?.getString(secondKey).orEmpty()
            val first = Uri.decode(firstEncoded)
            val second = Uri.decode(secondEncoded)
            Feature2Screen1(firstArg = first, secondArg = second)
        }
        composable(route = NavigationTree.Feature2Screen2.name) {
            Feature2Screen2()
        }
    }
}

fun NavController.navigateToFeature2(first: String, second: String) {
    //for any case encode string args
    val encodedFirst = Uri.encode(first)
    val encodedSecond = Uri.encode(second)
    navigate("feature2/$encodedFirst?second=$encodedSecond")
}
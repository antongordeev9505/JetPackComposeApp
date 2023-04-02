package com.example.jetpackcompose.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController

@Composable
fun NavigationExampleScreen(navController: NavController) {
    LaunchedEffect(key1 = Unit, block = {
        // navController имеет ссылку на текущий стэк навигации
        navController.navigate(route = "route") {
//          navOptionsBuilder let us to construct new NaV Options store
            //clear every screen in graph before "someScreen"
            popUpTo(route = "someScreen")
            // including "someScreen"
            popUpTo(route = "someScreen") { inclusive = true }
        }
        //pup up back
        navController.popBackStack()
        //pup up back to dest
//        navController.popBackStack(destinationId = 1)
        //Retrieve the current back stack.
        val backstack = navController.backQueue
        //currently active NavBackStackEntry
        val currentEntry = navController.currentBackStackEntryFlow
    })

}
package com.example.jetpackcompose.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun NavigationExampleScreen(
    viewModel: NavigationExampleScreenViewModel,
    onButtonClick: () -> Unit
) {
    ButtonWithClick(onButtonClick = viewModel::onClickNavigationNext)
    
    LaunchedEffect(true) {
        viewModel.effects.collect {
            when (it) {
                NavigationExampleScreenEffect.NavigateNext -> onButtonClick()
            }
        }
    }

//    LaunchedEffect(key1 = Unit, block = {
//        // navController имеет ссылку на текущий стэк навигации
//        navController.navigate(route = "route") {
////          navOptionsBuilder let us to construct new NaV Options store
//            //clear every screen in graph before "someScreen"
//            popUpTo(route = "someScreen")
//            // including "someScreen"
//            popUpTo(route = "someScreen") { inclusive = true }
//        }
//        //pup up back
//        navController.popBackStack()
//        //pup up back to dest
////        navController.popBackStack(destinationId = 1)
//        //Retrieve the current back stack.
//        val backstack = navController.backQueue
//        //currently active NavBackStackEntry
//        val currentEntry = navController.currentBackStackEntryFlow
//    })

}

@Composable
fun ButtonWithClick(onButtonClick: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Screen1", modifier = Modifier.align(Alignment.CenterHorizontally))
        Button(onClick = onButtonClick, modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(text = "Click to screen 2")
        }
    }
}
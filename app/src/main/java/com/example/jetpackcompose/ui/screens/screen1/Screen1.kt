package com.example.jetpackcompose.ui.screens.screen1

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.jetpackcompose.ui.screens.screen1.models.Screen1Event
import com.example.jetpackcompose.ui.screens.screen1.views.ListView

@Composable
fun Screen1(viewModel: Screen1ViewModel) {

    val viewState = viewModel.viewState.collectAsState()

//    LoadingView()
//    ErrorView()
    ListView(viewState.value) { title ->
        viewModel.obtainEvent(Screen1Event.IconClicked(title))
    }
}
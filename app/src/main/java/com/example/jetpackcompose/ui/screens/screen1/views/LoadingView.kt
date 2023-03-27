package com.example.jetpackcompose.ui.screens.screen1.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.jetpackcompose.ui.components.LoaderComponent

@Composable
fun LoadingView() {
    LoaderComponent(modifier = Modifier.fillMaxSize())
}
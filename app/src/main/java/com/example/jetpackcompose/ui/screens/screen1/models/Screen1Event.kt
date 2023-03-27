package com.example.jetpackcompose.ui.screens.screen1.models

sealed class Screen1Event {
    data class IconClicked(val title: String) : Screen1Event()
}

package com.example.jetpackcompose.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

sealed class NavigationExampleScreenEffect {
    object NavigateNext : NavigationExampleScreenEffect()
}

class NavigationExampleScreenViewModel : ViewModel() {

    private val _effects = Channel<NavigationExampleScreenEffect>()
    val effects: Flow<NavigationExampleScreenEffect> = _effects.receiveAsFlow()

    fun onClickNavigationNext() {
        viewModelScope.launch {
            _effects.send(NavigationExampleScreenEffect.NavigateNext)
        }
    }
}
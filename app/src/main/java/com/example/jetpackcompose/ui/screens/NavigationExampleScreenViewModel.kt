package com.example.jetpackcompose.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

sealed class NavigationExampleScreenEffect {
    data class NavigateToFeature2(val first: String, val second: String) : NavigationExampleScreenEffect()
}

class NavigationExampleScreenViewModel : ViewModel() {

    private val _effects = Channel<NavigationExampleScreenEffect>()
    val effects: Flow<NavigationExampleScreenEffect> = _effects.receiveAsFlow()

    fun onClickButton(first: String, second: String) {
        viewModelScope.launch {
            _effects.send(NavigationExampleScreenEffect.NavigateToFeature2(first, second))
        }
    }
}
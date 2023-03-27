package com.example.jetpackcompose.ui.screens.screen1

import androidx.lifecycle.ViewModel
import com.example.jetpackcompose.common.EventHandler
import com.example.jetpackcompose.ui.screens.screen1.models.Screen1Event
import com.example.jetpackcompose.ui.screens.screen1.models.Screen1ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class Screen1ViewModel @Inject constructor() : ViewModel(), EventHandler<Screen1Event> {

    private val _viewState = MutableStateFlow(Screen1ViewState())
    val viewState: StateFlow<Screen1ViewState> = _viewState

    override fun obtainEvent(event: Screen1Event) {
        when (event) {
            is Screen1Event.IconClicked -> onClickedIcon(event.title)
        }
    }

    private fun onClickedIcon(title: String) {
        val newList = _viewState.value.list.map {
            if (it.title == title) {
                it.copy(isDone = !it.isDone)
            } else {
                it
            }
        }
        _viewState.value = _viewState.value.copy(list = newList)
    }
}
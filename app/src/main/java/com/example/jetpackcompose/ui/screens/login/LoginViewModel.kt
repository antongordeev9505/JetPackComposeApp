package com.example.jetpackcompose.ui.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackcompose.common.EventHandler
import com.example.jetpackcompose.ui.screens.login.models.LoginEvent
import com.example.jetpackcompose.ui.screens.login.models.LoginViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel(), EventHandler<LoginEvent> {

    private val _viewState = MutableStateFlow<LoginViewState>(LoginViewState())
    val viewState: StateFlow<LoginViewState> = _viewState

    override fun obtainEvent(event: LoginEvent) {
        TODO("Not yet implemented")
    }
}
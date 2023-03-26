package com.example.jetpackcompose.ui.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcompose.common.EventHandler
import com.example.jetpackcompose.ui.screens.login.models.LoginAction
import com.example.jetpackcompose.ui.screens.login.models.LoginEvent
import com.example.jetpackcompose.ui.screens.login.models.LoginSubState
import com.example.jetpackcompose.ui.screens.login.models.LoginViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel(), EventHandler<LoginEvent> {

    private val _viewState = MutableStateFlow<LoginViewState>(LoginViewState())
    val viewState: StateFlow<LoginViewState> = _viewState

    override fun obtainEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.SignInClicked -> performSignIn()
            is LoginEvent.SignUpClicked -> performSignUp()
            is LoginEvent.EmailChanged -> emailChanged(event.value)
            is LoginEvent.PasswordChanged -> passwordChanged(event.value)
            is LoginEvent.ForgetClicked -> forgetClicked()
            is LoginEvent.CheckboxClicked -> checkboxClicked(event.value)
            is LoginEvent.LoginClicked -> loginClicked()
        }
    }

    private fun loginClicked() {
        viewModelScope.launch(Dispatchers.IO) {
            _viewState.value = _viewState.value.copy(isProgress = true)
            delay(3000)
            _viewState.value = _viewState.value.copy(
                    isProgress = false,
                    loginAction = LoginAction.OpenDashboard("Mobile Developer")
                )
        }
    }

    private fun emailChanged(value: String) {
        _viewState.value = _viewState.value.copy(emailValue = value)
    }

    private fun forgetClicked() {
        _viewState.value = _viewState.value.copy(loginSubState = LoginSubState.ForgotPassword)
    }

    private fun checkboxClicked(value: Boolean) {
        _viewState.value = _viewState.value.copy(rememberMeChecked = value)
    }

    private fun passwordChanged(value: String) {
        _viewState.value = _viewState.value.copy(passwordValue = value)
    }

    private fun performSignIn() {
        _viewState.value = _viewState.value.copy(loginSubState = LoginSubState.SignIn)
    }

    private fun performSignUp() {
        _viewState.value = _viewState.value.copy(loginSubState = LoginSubState.SignUp)
    }
}
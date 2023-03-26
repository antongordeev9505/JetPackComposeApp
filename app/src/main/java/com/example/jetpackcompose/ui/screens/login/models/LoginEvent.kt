package com.example.jetpackcompose.ui.screens.login.models

sealed class LoginEvent {
    object SignInClicked : LoginEvent()
    object SignUpClicked : LoginEvent()
    data class EmailChanged(val value: String) : LoginEvent()
    data class PasswordChanged(val value: String) : LoginEvent()
    object ForgetClicked : LoginEvent()
    object LoginClicked : LoginEvent()
    data class CheckboxClicked(val value: Boolean) : LoginEvent()
}

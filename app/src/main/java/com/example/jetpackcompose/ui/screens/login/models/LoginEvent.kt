package com.example.jetpackcompose.ui.screens.login.models

sealed class LoginEvent {
    object SignInClicked : LoginEvent()
    object SignUpClicked : LoginEvent()
    data class EmailChanged(val value: String) : LoginEvent()
}

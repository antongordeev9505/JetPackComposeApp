package com.example.jetpackcompose.ui.screens.login

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.R
import com.example.jetpackcompose.ui.screens.login.models.LoginSubState
import com.example.jetpackcompose.ui.theme.AppTheme

@Composable
fun LoginScreen(loginViewModel: LoginViewModel) {

    val viewState = loginViewModel.viewState.collectAsState()
}

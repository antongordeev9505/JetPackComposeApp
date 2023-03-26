package com.example.jetpackcompose.ui.screens.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.R
import com.example.jetpackcompose.ui.screens.login.models.LoginEvent
import com.example.jetpackcompose.ui.screens.login.models.LoginSubState
import com.example.jetpackcompose.ui.screens.login.views.ForgotPasswordView
import com.example.jetpackcompose.ui.screens.login.views.SignInView
import com.example.jetpackcompose.ui.screens.login.views.SignUpView
import com.example.jetpackcompose.ui.theme.AppTheme

@Composable
fun LoginScreen(loginViewModel: LoginViewModel) {

    val viewState = loginViewModel.viewState.collectAsState()

    with(viewState.value) {
        LazyColumn(modifier = Modifier.padding(start = 16.dp)) {
            item {
                Text(
                    modifier = Modifier.padding(top = 32.dp),
                    text = when (loginSubState) {
                        LoginSubState.SignIn -> stringResource(id = R.string.sign_in_title)
                        LoginSubState.SignUp -> stringResource(id = R.string.sign_up_title)
                        LoginSubState.ForgotPassword -> stringResource(id = R.string.forgot_password_title)
                    },
                    style = TextStyle(
                        color = AppTheme.colors.headerTextColor,
                        fontWeight = FontWeight.Bold,
                        fontSize = 50.sp
                    )
                )
            }


            item {
                Row(modifier = Modifier.padding(top = 8.dp)) {
                    Text(
                        text = when (loginSubState) {
                            LoginSubState.SignIn -> stringResource(id = R.string.sign_in_subtitle)
                            LoginSubState.SignUp -> stringResource(id = R.string.sign_up_subtitle)
                            LoginSubState.ForgotPassword -> stringResource(id = R.string.forgot_password_subtitle)
                        },
                        style = TextStyle(
                            color = AppTheme.colors.primaryTextColor
                        )
                    )

                    Spacer(modifier = Modifier.width(4.dp))
                    if (loginSubState != LoginSubState.ForgotPassword) {
                        Text(
                            modifier = Modifier.clickable {
                                when (loginSubState) {
                                    LoginSubState.SignIn -> loginViewModel.obtainEvent(LoginEvent.SignUpClicked)
                                    LoginSubState.SignUp -> loginViewModel.obtainEvent(LoginEvent.SignInClicked)
                                    else -> Unit
                                }
                            },
                            text = when (loginSubState) {
                                LoginSubState.SignIn -> stringResource(id = R.string.sign_in_action)
                                LoginSubState.SignUp -> stringResource(id = R.string.sign_up_action)
                                LoginSubState.ForgotPassword -> ""
                            },
                            style = TextStyle(
                                color = AppTheme.colors.actionTextColor,
                                fontWeight = FontWeight.Medium
                            )
                        )
                    }
                }
            }


            item {
                when (loginSubState) {
                    LoginSubState.SignIn -> SignInView(
                        viewState = this@with,
                        onLoginFieldChange = {
                            loginViewModel.obtainEvent(LoginEvent.EmailChanged(it))
                        },
                        onPasswordFieldChange = {
                            loginViewModel.obtainEvent(LoginEvent.PasswordChanged(it))
                        },
                        onCheckedChange = {
                            loginViewModel.obtainEvent(LoginEvent.CheckboxClicked(it))
                        },
                        onForgetClick = {
                            loginViewModel.obtainEvent(LoginEvent.ForgetClicked)
                        },
                        onLoginClick = {
                            loginViewModel.obtainEvent(LoginEvent.LoginClicked)
                        }
                    )
                    LoginSubState.SignUp -> SignUpView()
                    LoginSubState.ForgotPassword -> ForgotPasswordView()
                }
            }
        }
    }
}

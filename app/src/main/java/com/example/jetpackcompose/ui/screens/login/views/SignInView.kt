package com.example.jetpackcompose.ui.screens.login.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.R
import com.example.jetpackcompose.ui.components.DTextInput
import com.example.jetpackcompose.ui.screens.login.models.LoginViewState
import com.example.jetpackcompose.ui.theme.AppTheme

@Composable
fun SignInView(
    viewState: LoginViewState,
    onLoginFieldChange: (String) -> Unit,
    onPasswordFieldChange: (String) -> Unit,
    onCheckedChange: (Boolean) -> Unit,
    onForgetClick: () -> Unit,
    onLoginClick: () -> Unit
) {
    Column {
        DTextInput(
            modifier = Modifier.padding(top = 50.dp),
            header = stringResource(id = R.string.email_hint),
            textFieldValue = viewState.emailValue,
            enabled = !viewState.isProgress,
            onTextFieldChange = {
                if (!viewState.isProgress)
                    onLoginFieldChange.invoke(it)
            }
        )

        DTextInput(
            modifier = Modifier.padding(top = 30.dp),
            header = stringResource(id = R.string.password_hint),
            textFieldValue = viewState.passwordValue,
            enabled = !viewState.isProgress,
            secureText = true,
            onTextFieldChange = {
                if (!viewState.isProgress)
                    onPasswordFieldChange.invoke(it)
            }
        )

        Row(
            modifier = Modifier.padding(top = 40.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = viewState.rememberMeChecked,
                onCheckedChange = onCheckedChange,
                enabled = !viewState.isProgress,
                colors = CheckboxDefaults.colors(
                    checkedColor = AppTheme.colors.primaryTintColor,
                    uncheckedColor = AppTheme.colors.actionTextColor
                )
            )

            Text(text = stringResource(id = R.string.remember_check_title))

            Spacer(modifier = Modifier.weight(1f))

            Text(
                modifier = if (viewState.isProgress) Modifier else Modifier.clickable(onClick = onForgetClick),
                text = stringResource(id = R.string.sign_in_forget)
            )

            Button(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth()
                    .height(60.dp),
                onClick = {
                    if (!viewState.isProgress)
                        onLoginClick.invoke()
                },
                shape = RoundedCornerShape(size = 10.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = AppTheme.colors.primaryTintColor
                )
            ) {
                if (viewState.isProgress) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(24.dp),
                        strokeWidth = 2.dp,
                        color = AppTheme.colors.primaryTextInvertColor
                    )
                } else {
                    Text(
                        text = stringResource(id = R.string.action_login),
                        fontWeight = FontWeight.Medium,
                        color = AppTheme.colors.primaryTextInvertColor
                    )
                }
            }
        }
    }
}
package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.SideEffect
import com.example.jetpackcompose.ui.screens.ApplicationScreen
import com.example.jetpackcompose.ui.theme.AppTheme
import com.example.jetpackcompose.ui.theme.JetPackComposeTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeTheme {
                val systemUiController = rememberSystemUiController()

                // Set status bar color
                val primaryBackground = AppTheme.colors.primaryBackground
                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = primaryBackground,
                        darkIcons = true
                    )
                }
                ApplicationScreen()
            }
        }
    }
}
package com.example.jetpackcompose.ui.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun Feature2Screen1(firstArg: String, secondArg: String) {
    Text(text = "Screen2 with args: $firstArg and $secondArg")
}
package com.example.jetpackcompose.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ErrorComponent() {
    Column(Modifier.fillMaxSize()) {
        ErrorDescriptionComponent(mainModifier = Modifier
            .fillMaxSize()
            .weight(1f))
        ButtonComponent(
            mainModifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 32.dp)
        )
    }
}
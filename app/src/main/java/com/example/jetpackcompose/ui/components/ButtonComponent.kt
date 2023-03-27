package com.example.jetpackcompose.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.R

@Composable
fun ButtonComponent(buttonOnClickAction: () -> Unit = {}, mainModifier: Modifier = Modifier) {
    Button(
        onClick = buttonOnClickAction,
        shape = RoundedCornerShape(50),
        contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp),
        modifier = mainModifier
    ) {
        Text(text = "Refresh", modifier = Modifier.weight(1f))
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_refresh_24),
            contentDescription = null
        )
    }
}
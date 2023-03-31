package com.example.jetpackcompose.ui.screens.screen1

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun AnimationScreen() {

    val isVisible = remember {
        mutableStateOf(false)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(
                modifier = Modifier,
                onClick = { isVisible.value = !isVisible.value }) {
                Text(text = "Press")
            }
            // animate visibility, also there is AnimatedContent
            AnimatedVisibility(
                visible = isVisible.value,
                modifier = Modifier,
                enter = expandHorizontally()
            ) {
                Text(
                    modifier = Modifier,
                    text = "Hello World",
                    fontSize = 30.sp
                )
            }
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            val alpha: Float by animateFloatAsState(
                if (isVisible.value) 1f else 0f,
                animationSpec = tween(1000)
            )
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .graphicsLayer(alpha = alpha)
                    .background(Color.Red)
            )
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            //create State with animated color
            val color by animateColorAsState(
                if (isVisible.value) Color.Red else Color.Blue
            )
            //create State with animated Size
            val size by animateDpAsState(
                if (isVisible.value) 60.dp else 100.dp
            )

            AnimatedSquare(
                color = color,
                size = size
            )
        }
    }
}

@Composable
fun AnimatedSquare(
    color: Color = Color.Red,
    size: Dp = 60.dp
) {
    Box(
        Modifier
            .height(size)
            .width(size)
            .background(color)
    )
}
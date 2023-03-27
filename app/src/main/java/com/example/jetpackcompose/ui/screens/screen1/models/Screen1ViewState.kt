package com.example.jetpackcompose.ui.screens.screen1.models

import androidx.compose.runtime.Stable
import com.example.jetpackcompose.sample.MyCard
import com.example.jetpackcompose.sample.SampleData

@Stable
data class Screen1ViewState(
    val list: List<MyCard> = SampleData.getList()
)

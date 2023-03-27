package com.example.jetpackcompose.ui.screens.screen1

import androidx.compose.runtime.Composable
import com.example.jetpackcompose.sample.SampleData
import com.example.jetpackcompose.ui.screens.screen1.views.ErrorView
import com.example.jetpackcompose.ui.screens.screen1.views.ListView

@Composable
fun Screen1() {
    val data = SampleData.getList()
//    LoadingView()
//    ErrorView()
    ListView(data)
}
package com.example.jetpackcompose.ui.screens.screen1.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.sample.MyCard
import com.example.jetpackcompose.ui.components.CardComponent

@Composable
fun ListView(list: List<MyCard>) {
    LazyColumn(
        contentPadding = PaddingValues(vertical = 16.dp, horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(list) { card ->
            CardComponent(card)
        }
    }
}
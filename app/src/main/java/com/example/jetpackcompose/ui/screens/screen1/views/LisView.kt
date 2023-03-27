package com.example.jetpackcompose.ui.screens.screen1.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.components.CardComponent
import com.example.jetpackcompose.ui.screens.screen1.models.Screen1ViewState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListView(viewState: Screen1ViewState, onIconClickAction: (String) -> Unit) {
    LazyColumn(
        contentPadding = PaddingValues(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        val groupedItems = viewState.list.groupBy { it.isDone }
        groupedItems.forEach { (isDone, cards) ->
            stickyHeader {
                Text(
                    text = if (isDone) {
                        "Done"
                    } else {
                        "Undone"
                    },
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
            items(cards, key = { it.title }) { card ->
                CardComponent(
                    item = card,
                    mainModifier = Modifier
                        .padding(horizontal = 16.dp)
                        .animateItemPlacement(),
                    onClickIconAction = onIconClickAction
                )
            }
        }
    }
}
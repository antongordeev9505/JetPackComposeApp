package com.example.jetpackcompose.sample

data class MyCard(val title: String, val description: String, val isDone: Boolean)
object SampleData {
    fun getList(): List<MyCard> {
        return listOf(
            MyCard(
                title = "Title 1",
                description = "Description 1",
                isDone = true
            ),
            MyCard(
                title = "Title 2",
                description = "Description 2",
                isDone = false
            ),
            MyCard(
                title = "Title 3",
                description = "Description 3",
                isDone = true
            ),
            MyCard(
                title = "Title 4",
                description = "Description 4",
                isDone = false
            ),
        )
    }
}
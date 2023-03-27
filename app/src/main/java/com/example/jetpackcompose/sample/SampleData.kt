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
            MyCard(
                title = "Title 5",
                description = "Description 5",
                isDone = true
            ),
            MyCard(
                title = "Title 6",
                description = "Description 6",
                isDone = false
            ),
            MyCard(
                title = "Title 7",
                description = "Description 7",
                isDone = true
            ),
            MyCard(
                title = "Title 8",
                description = "Description 8",
                isDone = false
            ),
            MyCard(
                title = "Title 9",
                description = "Description 9",
                isDone = true
            ),
            MyCard(
                title = "Title 10",
                description = "Description 10",
                isDone = false
            ),
            MyCard(
                title = "Title 11",
                description = "Description 11",
                isDone = true
            ),
        )
    }
}
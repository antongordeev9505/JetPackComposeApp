package com.example.jetpackcompose.common

interface EventHandler<T> {
    fun obtainEvent(event: T)
}
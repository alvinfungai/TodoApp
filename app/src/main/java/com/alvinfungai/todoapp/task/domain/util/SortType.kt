package com.alvinfungai.todoapp.task.domain.util

sealed class SortType {
    object Ascending: SortType()
    object Descending: SortType()
}

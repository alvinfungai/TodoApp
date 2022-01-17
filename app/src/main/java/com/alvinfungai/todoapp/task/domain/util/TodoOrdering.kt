package com.alvinfungai.todoapp.task.domain.util

sealed class TodoOrdering(val sortType: SortType) {
    class Title(sortType: SortType): TodoOrdering(sortType)
    class Date(sortType: SortType): TodoOrdering(sortType)
    class Priority(sortType: SortType): TodoOrdering(sortType)

    fun copy(sortType: SortType): TodoOrdering {
        return when(this) {
            is Title -> Title(sortType)
            is Date -> Date(sortType)
            is Priority -> Priority(sortType)
        }
    }
}
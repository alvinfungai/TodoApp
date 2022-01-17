package com.alvinfungai.todoapp.task.presentation.todo

import com.alvinfungai.todoapp.task.domain.model.Todo
import com.alvinfungai.todoapp.task.domain.util.SortType
import com.alvinfungai.todoapp.task.domain.util.TodoOrdering

data class TodoState(
    val todos: List<Todo> = emptyList(),
    val todoOrdering: TodoOrdering = TodoOrdering.Priority(SortType.Descending),
    val isSortOrderOptionsVisible: Boolean = false
)

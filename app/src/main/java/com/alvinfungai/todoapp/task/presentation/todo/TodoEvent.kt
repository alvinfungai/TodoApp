package com.alvinfungai.todoapp.task.presentation.todo

import com.alvinfungai.todoapp.task.domain.model.Todo
import com.alvinfungai.todoapp.task.domain.util.TodoOrdering

sealed class TodoEvent {
    data class Sort(val todoOrdering: TodoOrdering): TodoEvent()
    data class DeleteTodo(val todo: Todo): TodoEvent()
    object ToggleSortOrderOptions: TodoEvent()
    object UndoDeleteTodo: TodoEvent()
}

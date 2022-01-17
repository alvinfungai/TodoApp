package com.alvinfungai.todoapp.task.domain.use_case

import com.alvinfungai.todoapp.task.domain.model.Todo
import com.alvinfungai.todoapp.task.domain.repository.TodoRepository
import com.alvinfungai.todoapp.task.domain.util.SortType
import com.alvinfungai.todoapp.task.domain.util.TodoOrdering
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetTodos(
    private val repository: TodoRepository
) {

    operator fun invoke(
        todoOrdering: TodoOrdering = TodoOrdering.Priority(SortType.Descending)
    ): Flow<List<Todo>> {
        return repository.getTodos().map { todos ->
            when (todoOrdering.sortType) {
                is SortType.Ascending -> {
                   when (todoOrdering) {
                       is TodoOrdering.Priority -> todos.sortedBy { it.flagColor }
                       is TodoOrdering.Date -> todos.sortedBy { it.timestamp }
                       is TodoOrdering.Title -> todos.sortedBy { it.title.lowercase() }
                   }
                }
                is SortType.Descending -> {
                    when (todoOrdering) {
                        is TodoOrdering.Priority -> todos.sortedByDescending { it.flagColor }
                        is TodoOrdering.Date -> todos.sortedByDescending { it.timestamp }
                        is TodoOrdering.Title -> todos.sortedByDescending { it.title.lowercase() }
                    }
                }
            }
        }
    }
}
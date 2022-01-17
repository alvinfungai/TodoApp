package com.alvinfungai.todoapp.task.domain.use_case

import com.alvinfungai.todoapp.task.domain.model.Todo
import com.alvinfungai.todoapp.task.domain.repository.TodoRepository

class DeleteTodo(
    private val repository: TodoRepository
) {

    suspend operator fun invoke(todo: Todo) {
        repository.deleteTodo(todo)
    }
}
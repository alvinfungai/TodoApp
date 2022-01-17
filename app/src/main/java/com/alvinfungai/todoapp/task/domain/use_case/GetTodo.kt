package com.alvinfungai.todoapp.task.domain.use_case

import com.alvinfungai.todoapp.task.domain.repository.TodoRepository

class GetTodo(
    private val repository: TodoRepository
) {
    suspend operator fun invoke(id: Int) {
        repository.getTodo(id)
    }
}
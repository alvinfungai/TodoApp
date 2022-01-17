package com.alvinfungai.todoapp.task.domain.repository

import com.alvinfungai.todoapp.task.domain.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {

    fun getTodos(): Flow<List<Todo>>

    suspend fun getTodo(id: Int): Todo?

    suspend fun insertTodo(todo: Todo)

    suspend fun deleteTodo(todo: Todo)
}
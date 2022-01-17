package com.alvinfungai.todoapp.task.data.repository

import com.alvinfungai.todoapp.task.data.source.TodoDao
import com.alvinfungai.todoapp.task.domain.model.Todo
import com.alvinfungai.todoapp.task.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow

class TodoRepositoryImpl(
    private val todoDao: TodoDao
) : TodoRepository {
    override fun getTodos(): Flow<List<Todo>> {
        return todoDao.getTodos()
    }

    override suspend fun getTodo(id: Int): Todo? {
        return todoDao.getTodoById(id)
    }

    override suspend fun insertTodo(todo: Todo) {
        todoDao.insertTodo(todo)
    }

    override suspend fun deleteTodo(todo: Todo) {
        todoDao.deleteTodo(todo)
    }
}
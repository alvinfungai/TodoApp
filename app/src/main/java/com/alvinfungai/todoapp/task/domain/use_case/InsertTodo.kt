package com.alvinfungai.todoapp.task.domain.use_case

import com.alvinfungai.todoapp.task.domain.model.InvalidTodoException
import com.alvinfungai.todoapp.task.domain.model.Todo
import com.alvinfungai.todoapp.task.domain.repository.TodoRepository



class InsertTodo(
    private val repository: TodoRepository
) {

    @Throws(InvalidTodoException::class)
    suspend operator fun invoke(todo: Todo) {

        if (todo.title.isBlank()) throw InvalidTodoException("Please insert note title")
        if (todo.content.isBlank()) throw InvalidTodoException("Please insert note content")
        repository.insertTodo(todo)
    }
}
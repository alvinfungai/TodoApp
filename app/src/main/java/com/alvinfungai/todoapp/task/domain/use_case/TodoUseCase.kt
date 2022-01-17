package com.alvinfungai.todoapp.task.domain.use_case

data class TodoUseCase (
    val getTodos: GetTodos,
    val getTodo: GetTodo,
    val insertTodo: InsertTodo,
    val deleteTodo: DeleteTodo
)
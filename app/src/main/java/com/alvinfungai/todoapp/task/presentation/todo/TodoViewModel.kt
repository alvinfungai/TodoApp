package com.alvinfungai.todoapp.task.presentation.todo

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alvinfungai.todoapp.task.domain.model.Todo
import com.alvinfungai.todoapp.task.domain.use_case.TodoUseCase
import com.alvinfungai.todoapp.task.domain.util.SortType
import com.alvinfungai.todoapp.task.domain.util.TodoOrdering
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TodoViewModel @Inject constructor(
    private val todoUseCase: TodoUseCase
) : ViewModel() {

    private val _state = mutableStateOf(TodoState())
    val state: State<TodoState> = _state
    private var recentlyDeletedTodo: Todo? = null
    private var getTodosJob: Job? = null

    init {
        getTodos(TodoOrdering.Priority(SortType.Descending))
    }

    fun onEvent(event: TodoEvent) {
        when (event) {
            is TodoEvent.ToggleSortOrderOptions -> {
                _state.value = state.value.copy(
                    isSortOrderOptionsVisible = !state.value.isSortOrderOptionsVisible
                )
            }
            is TodoEvent.Sort -> {
                if (state.value.todoOrdering::class == event.todoOrdering::class &&
                    state.value.todoOrdering.sortType == event.todoOrdering.sortType
                ) {
                    return
                }
                getTodos(event.todoOrdering)
            }
            is TodoEvent.DeleteTodo -> {
                viewModelScope.launch {
                    todoUseCase.deleteTodo(event.todo)
                    recentlyDeletedTodo = event.todo
                }
            }
            is TodoEvent.UndoDeleteTodo -> {
                viewModelScope.launch {
                    todoUseCase.insertTodo(recentlyDeletedTodo ?: return@launch)
                    recentlyDeletedTodo = null
                }
            }
        }
    }

    private fun getTodos(todoOrdering: TodoOrdering) {
        getTodosJob?.cancel()
        getTodosJob = todoUseCase.getTodos(todoOrdering).onEach { todos ->
            _state.value = state.value.copy(
                todos = todos,
                todoOrdering = todoOrdering
            )
        }.launchIn(viewModelScope)
    }
}
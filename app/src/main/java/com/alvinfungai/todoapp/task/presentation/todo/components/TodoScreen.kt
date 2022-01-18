package com.alvinfungai.todoapp.task.presentation.todo.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alvinfungai.todoapp.task.presentation.todo.TodoViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun TodoScreen(
    navController: NavController,
    viewModel: TodoViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add todo")
            }
        },
        scaffoldState = scaffoldState
    ) {

    }
}
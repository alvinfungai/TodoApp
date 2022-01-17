package com.alvinfungai.todoapp.task.presentation.todo.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alvinfungai.todoapp.task.domain.util.SortType
import com.alvinfungai.todoapp.task.domain.util.TodoOrdering
import com.alvinfungai.todoapp.ui.GenericRadioButton

@Composable
fun TodoSortingOptions(
    modifier: Modifier = Modifier,
    todoOrdering: TodoOrdering = TodoOrdering.Priority(SortType.Descending),
    onOrderChange: (TodoOrdering) -> Unit
) {
   Column(
       modifier = modifier
   ) {
       Row(
           modifier = Modifier.fillMaxWidth()
       ) {
           GenericRadioButton(
               label = "Priority", 
               selected = todoOrdering is TodoOrdering.Priority, 
               onSelect = { onOrderChange(TodoOrdering.Priority(todoOrdering.sortType)) },
               modifier = modifier
           )
           Spacer(modifier = Modifier.width(8.dp))
           GenericRadioButton(
               label = "Date",
               selected = todoOrdering is TodoOrdering.Date,
               onSelect = { onOrderChange(TodoOrdering.Date(todoOrdering.sortType)) },
               modifier = modifier
           )
           Spacer(modifier = Modifier.width(8.dp))
           GenericRadioButton(
               label = "Title",
               selected = todoOrdering is TodoOrdering.Title,
               onSelect = { onOrderChange(TodoOrdering.Title(todoOrdering.sortType)) },
               modifier = modifier
           )
           Spacer(modifier = Modifier.height(16.dp))
       }
       Row(
           modifier = Modifier.fillMaxWidth()
       ) {
           GenericRadioButton(
               label = "Ascending",
               selected = todoOrdering.sortType is SortType.Ascending,
               onSelect = { onOrderChange(todoOrdering.copy(SortType.Ascending)) },
               modifier = modifier
           )
           Spacer(modifier = Modifier.width(8.dp))
           GenericRadioButton(
               label = "Descending",
               selected = todoOrdering.sortType is SortType.Descending,
               onSelect = { onOrderChange(todoOrdering.copy(SortType.Descending)) },
               modifier = modifier
           )
       }
   } 
}

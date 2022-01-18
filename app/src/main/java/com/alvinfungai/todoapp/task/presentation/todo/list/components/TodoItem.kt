package com.alvinfungai.todoapp.task.presentation.todo.list.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun TodoItem() {
    Row(modifier = Modifier.fillMaxWidth()) {
        TodoPriorityColor(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 16.dp, end = 16.dp),
            color = Color.Gray,
            size = 40.dp
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        ) {
            Text(text = "Title", maxLines = 1)
            Text(text = "Content", maxLines = 1)
        }
        Checkbox(
            checked = false,
            onCheckedChange = {},
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterVertically)
        )
    }
}

@Preview
@Composable
private fun TodoItemPreview() {
    TodoItem()
}
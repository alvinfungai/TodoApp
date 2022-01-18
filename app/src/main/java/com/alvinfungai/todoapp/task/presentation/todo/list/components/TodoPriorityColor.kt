package com.alvinfungai.todoapp.task.presentation.todo.list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun TodoPriorityColor(
    modifier: Modifier = Modifier,
    color: Color,
    size: Dp,
    padding: Dp = 0.dp
) {
    Box(
        modifier = modifier
            .padding(padding)
            .size(size)
            .clip(CircleShape)
            .background(Color.Red)
    )
}

@Preview
@Composable
fun TodoPriorityColorPreview() {
    TodoPriorityColor(
        color = Color.Red,
        size = 40.dp,
        padding = 4.dp
    )
}
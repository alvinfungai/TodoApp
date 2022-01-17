package com.alvinfungai.todoapp.task.domain.model

import android.graphics.Color
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.res.colorResource
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alvinfungai.todoapp.R
import com.alvinfungai.todoapp.ui.theme.Amber700
import com.alvinfungai.todoapp.ui.theme.BlueGray200
import com.alvinfungai.todoapp.ui.theme.Green500
import com.alvinfungai.todoapp.ui.theme.Red500
import java.lang.Exception
import java.sql.Timestamp


@Entity
data class Todo(
    @PrimaryKey val id: Int? = null,
    val title: String,
    val content: String,
    val timestamp: Long,
    val flagColor: Int,
    val isCheckedOff: Boolean = false
) {
    companion object {
        val noteFlagColors = listOf(Red500, Amber700, Green500, BlueGray200)
    }
}

class InvalidTodoException(message: String): Exception(message)

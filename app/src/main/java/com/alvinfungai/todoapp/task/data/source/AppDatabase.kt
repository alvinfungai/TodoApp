package com.alvinfungai.todoapp.task.data.source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alvinfungai.todoapp.task.domain.model.Todo


@Database(entities = [Todo::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract val todoDao: TodoDao

    companion object {
        const val DATABASE_NAME = "todo_db"
    }
}
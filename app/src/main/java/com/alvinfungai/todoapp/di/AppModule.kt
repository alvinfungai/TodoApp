package com.alvinfungai.todoapp.di

import android.app.Application
import androidx.room.Room
import com.alvinfungai.todoapp.task.data.repository.TodoRepositoryImpl
import com.alvinfungai.todoapp.task.data.source.AppDatabase
import com.alvinfungai.todoapp.task.domain.repository.TodoRepository
import com.alvinfungai.todoapp.task.domain.use_case.GetTodos
import com.alvinfungai.todoapp.task.domain.use_case.TodoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideTodoRepository(db: AppDatabase): TodoRepository {
        return TodoRepositoryImpl(db.todoDao)
    }

    @Provides
    @Singleton
    fun provideTodoUseCase(repository: TodoRepository): TodoUseCase {
        return TodoUseCase(
            getTodos = GetTodos(repository)
        )
    }
}
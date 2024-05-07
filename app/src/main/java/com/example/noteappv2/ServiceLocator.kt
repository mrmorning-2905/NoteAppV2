package com.example.noteappv2

import android.content.Context
import com.example.noteappv2.data.AppDataBase
import com.example.noteappv2.data.datasource.IUserDataSource
import com.example.noteappv2.data.datasource.LocalNoteDataSourceImpl
import com.example.noteappv2.data.datasource.UserDataSourceImpl
import com.example.noteappv2.data.repository.INoteRepo
import com.example.noteappv2.data.repository.IUserRepo
import com.example.noteappv2.data.repository.NoteRepositoryImpl
import com.example.noteappv2.data.repository.UserRepositoryImpl

object ServiceLocator {

    fun provideUserRepo(context: Context): IUserRepo {
        return UserRepositoryImpl(createUserDataSource(context))
    }

    fun provideNoteRepo(context: Context): INoteRepo {
        val appDataBase = AppDataBase.getInstance(context)
        val noteLocalDataSource = LocalNoteDataSourceImpl(appDataBase.noteDao())
        return NoteRepositoryImpl(noteLocalDataSource = noteLocalDataSource)
    }

    private fun createUserDataSource(context: Context): IUserDataSource {
        val appDataBase = AppDataBase.getInstance(context)
        return UserDataSourceImpl(appDataBase.userDao())
    }
}
package com.example.noteappv2

import android.content.Context
import com.example.noteappv2.data.AppDataBase
import com.example.noteappv2.data.datasource.IUserDataSource
import com.example.noteappv2.data.datasource.UserDataSourceImpl
import com.example.noteappv2.data.repository.IUserRepo
import com.example.noteappv2.data.repository.UserRepositoryImpl

object ServiceLocator {

    fun provideUserRepo(context: Context): IUserRepo {
        return UserRepositoryImpl(createUserDataSource(context))
    }

    private fun createUserDataSource(context: Context): IUserDataSource {
        val appDataBase = AppDataBase.getInstance(context)
        return UserDataSourceImpl(appDataBase.userDao())
    }
}
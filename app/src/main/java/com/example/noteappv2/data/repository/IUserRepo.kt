package com.example.noteappv2.data.repository

import androidx.lifecycle.LiveData
import com.example.noteappv2.data.entity.UserEntity
import com.example.noteappv2.utils.ResultState

interface IUserRepo {
    fun observerAllUser(): LiveData<ResultState<List<UserEntity>>>

    fun observerUserById(uId: Long): LiveData<ResultState<UserEntity>>

    suspend fun getUserById(uId: Long): ResultState<UserEntity>

    suspend fun login(uName: String, uPassword: String): ResultState<UserEntity>

    suspend fun registerAccount(user: UserEntity): ResultState<Any>

    suspend fun getAllUser(): ResultState<List<UserEntity>>
}
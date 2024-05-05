package com.example.noteappv2.data.repository

import androidx.lifecycle.LiveData
import com.example.noteappv2.data.datasource.IUserDataSource
import com.example.noteappv2.data.entity.UserEntity
import com.example.noteappv2.utils.ResultState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class UserRepositoryImpl(
    private val userDataSource: IUserDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO) : IUserRepo {

    override fun observerAllUser(): LiveData<ResultState<List<UserEntity>>> {
        return userDataSource.observerAllUser()
    }

    override fun observerUserById(uId: Long): LiveData<ResultState<UserEntity>> {
        return userDataSource.observerUserById(uId)
    }

    override suspend fun getUserById(uId: Long): ResultState<UserEntity> {
        return userDataSource.getUserById(uId)
    }

    override suspend fun login(uName: String, uPassword: String): ResultState<UserEntity> {
        return userDataSource.login(uName, uPassword)
    }

    override suspend fun registerAccount(user: UserEntity): ResultState<Any> {
        return userDataSource.registerAccount(user)
    }

    override suspend fun getAllUser(): ResultState<List<UserEntity>> {
        return userDataSource.getAllUser()
    }


}
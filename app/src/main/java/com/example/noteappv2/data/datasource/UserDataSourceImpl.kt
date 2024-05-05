package com.example.noteappv2.data.datasource

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.noteappv2.data.dao.UserDao
import com.example.noteappv2.data.entity.UserEntity
import com.example.noteappv2.utils.ResultState
import com.example.noteappv2.utils.ResultState.Success
import com.example.noteappv2.utils.ResultState.Error
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserDataSourceImpl(
    private val userDao: UserDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : IUserDataSource {

    override fun observerAllUser(): LiveData<ResultState<List<UserEntity>>> {
        return userDao.observerAllUser().map {
            Success(it)
        }
    }

    override fun observerUserById(uId: Long): LiveData<ResultState<UserEntity>> {
        return userDao.observerUserById(uId).map {
            Success(it)
        }
    }

    override suspend fun getUserById(uId: Long): ResultState<UserEntity> = withContext(ioDispatcher) {
        try {
            val user = userDao.findUserById(uId)
            if (user != null) {
                return@withContext Success(user)
            } else {
                return@withContext Error(Exception("Not found any user"))
            }
        } catch (e: Exception) {
            return@withContext Error(e)
        }
    }

    override suspend fun login(uName: String, uPassword: String): ResultState<UserEntity> = withContext(ioDispatcher) {
        try {
            val user = userDao.findUserExist(uName, uPassword)
            if (user != null) {
                return@withContext Success(user)
            } else {
                return@withContext Error(Exception("This user doesn't register an account!"))
            }
        } catch (e: Exception) {
            return@withContext Error(e)
        }
    }

    override suspend fun registerAccount(user: UserEntity): ResultState<String> = withContext(ioDispatcher) {
        return@withContext try {
            userDao.insertOneUser(user)
            Success("register success user: $user")
        } catch (e: Exception) {
            Error(e)
        }
    }

    override suspend fun getAllUser(): ResultState<List<UserEntity>> = withContext(ioDispatcher) {
        return@withContext try {
            Success(userDao.getAllUser())
        } catch (e: Exception) {
            Error(e)
        }
    }


}
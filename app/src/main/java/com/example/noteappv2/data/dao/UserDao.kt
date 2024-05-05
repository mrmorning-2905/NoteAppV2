package com.example.noteappv2.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.noteappv2.data.entity.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM USER_TABLE")
    fun observerAllUser(): LiveData<List<UserEntity>>

    @Query("SELECT * FROM USER_TABLE")
    suspend fun getAllUser(): List<UserEntity>

    @Query("SELECT * FROM USER_TABLE WHERE user_id = :userId")
    fun observerUserById(userId: Long): LiveData<UserEntity>

    @Query("SELECT * FROM USER_TABLE WHERE user_id = :userId")
    suspend fun findUserById(userId: Long): UserEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOneUser(user: UserEntity)

    @Insert
    suspend fun insertManyUser(userList: List<UserEntity>)

    @Update
    suspend fun updateUser(user: UserEntity)

    @Delete
    suspend fun deleteUser(user: UserEntity)

    @Query("SELECT * FROM USER_TABLE WHERE user_name = :userName AND password = :userPassword")
    suspend fun findUserExist(userName: String, userPassword: String): UserEntity?
}
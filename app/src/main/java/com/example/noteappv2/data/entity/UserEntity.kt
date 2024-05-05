package com.example.noteappv2.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "USER_TABLE")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    val uId: Long?,

    @ColumnInfo(name = "user_name")
    val userName: String,

    @ColumnInfo(name = "password")
    val password: String
)

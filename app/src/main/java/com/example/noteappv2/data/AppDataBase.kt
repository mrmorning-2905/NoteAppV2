package com.example.noteappv2.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noteappv2.data.dao.NoteDao
import com.example.noteappv2.data.dao.UserDao
import com.example.noteappv2.data.entity.NoteEntity
import com.example.noteappv2.data.entity.UserEntity

@Database(
    entities = [UserEntity::class, NoteEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun noteDao(): NoteDao

    companion object {
        private const val DB_NAME = "NOTE_APP.db"

        @Volatile
        private var INSTANCE: AppDataBase? = null

        private fun buildDatabase(context: Context): AppDataBase {
            return Room.databaseBuilder(
                context = context.applicationContext,
                klass = AppDataBase::class.java,
                name = DB_NAME
            ).build()
        }

        fun getInstance(context: Context): AppDataBase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }
        }
    }
}
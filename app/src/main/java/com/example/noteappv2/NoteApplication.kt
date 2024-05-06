package com.example.noteappv2

import android.app.Application
import com.example.noteappv2.data.repository.IUserRepo
import com.example.noteappv2.utils.log.LogcatLogWriter
import com.example.noteappv2.utils.log.Logger

class NoteApplication : Application() {
    val userRepository: IUserRepo
        get() = ServiceLocator.provideUserRepo(this)

    override fun onCreate() {
        super.onCreate()
        Logger.init(LogcatLogWriter())
    }
}
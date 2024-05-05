package com.example.noteappv2

import android.app.Application
import com.example.noteappv2.data.repository.IUserRepo

class NoteApplication : Application() {
    val userRepository: IUserRepo
        get() = ServiceLocator.provideUserRepo(this)

    override fun onCreate() {
        super.onCreate()
    }
}
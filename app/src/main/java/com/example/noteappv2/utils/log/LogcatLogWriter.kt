package com.example.noteappv2.utils.log

import android.util.Log

class LogcatLogWriter : LogWriter {
    private val NOTE_APP_TAG = "NoteApp_"
    override fun v(msg: String) {
        Log.v(NOTE_APP_TAG, msg)
    }

    override fun d(msg: String) {
        Log.d(NOTE_APP_TAG, msg)
    }

    override fun i(msg: String) {
        Log.i(NOTE_APP_TAG, msg)
    }

    override fun w(msg: String) {
        Log.w(NOTE_APP_TAG, msg)
    }

    override fun e(msg: String) {
        Log.e(NOTE_APP_TAG, msg)
    }
}
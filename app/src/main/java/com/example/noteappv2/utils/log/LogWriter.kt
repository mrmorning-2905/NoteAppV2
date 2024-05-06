package com.example.noteappv2.utils.log

interface LogWriter {
    fun v(msg: String)
    fun d(msg: String)
    fun i(msg: String)
    fun w(msg: String)
    fun e(msg: String)
}
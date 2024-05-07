package com.example.noteappv2.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.noteappv2.NoteApplication
import com.example.noteappv2.data.repository.INoteRepo

class NotesListViewModel(
    application: Application,
    private val noteRepo: INoteRepo
) : AndroidViewModel(application) {

    private val logTag = NotesListViewModel::class.java.simpleName



}
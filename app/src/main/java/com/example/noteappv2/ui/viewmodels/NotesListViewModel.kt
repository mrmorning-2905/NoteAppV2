package com.example.noteappv2.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteappv2.NoteApplication
import com.example.noteappv2.data.entity.NoteEntity
import com.example.noteappv2.data.repository.INoteRepo
import kotlinx.coroutines.launch

class NotesListViewModel(
    application: Application,
    private val noteRepo: INoteRepo
) : AndroidViewModel(application) {

    private val logTag = NotesListViewModel::class.java.simpleName

    fun addFakeData() {
        viewModelScope.launch {
            val notes = List(10) {index ->
                NoteEntity(
                    noteId = null,
                    noteTitle = "note_$index",
                    noteDetails = "fake note: $index",
                    lastModified = System.currentTimeMillis(),
                    ownerUId = 1L
                )
            }

            noteRepo.addManyNotes(notes)
        }
    }

}
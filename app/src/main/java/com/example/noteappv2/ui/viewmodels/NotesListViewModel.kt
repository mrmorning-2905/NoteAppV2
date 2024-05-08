package com.example.noteappv2.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.viewModelScope
import com.example.noteappv2.NoteApplication
import com.example.noteappv2.data.entity.NoteEntity
import com.example.noteappv2.data.repository.INoteRepo
import com.example.noteappv2.utils.ResultState
import com.example.noteappv2.utils.log.Logger
import kotlinx.coroutines.launch
import kotlin.math.log

class NotesListViewModel(
    application: Application,
    private val noteRepo: INoteRepo
) : AndroidViewModel(application) {

    private val logTag = NotesListViewModel::class.java.simpleName

    init {
        addFakeData()
    }

    private fun addFakeData() {
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

    fun getAllNote() {
        viewModelScope.launch {
            noteRepo.getAllNotes().let { result ->
                if (result is ResultState.Success) {
                    val listNote = result.data
                    Logger.d(logTag, "result is: $listNote")
                } else {
                    Logger.d(logTag, "fail to get all note")
                }
            }
        }
    }

    fun observerNotesWithOwner(ownerId: Long, lifecycleOwner: LifecycleOwner) {
        noteRepo.observerAllNoteByUserId(ownerId).observe(lifecycleOwner) {result ->
            if (result is ResultState.Success) {
                val userAndNote = result.data
                Logger.d(logTag, "owner with id: $ownerId have all note: \n ${userAndNote.notes}")
            }
        }
    }
}
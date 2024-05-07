package com.example.noteappv2.data.datasource

import androidx.lifecycle.LiveData
import com.example.noteappv2.data.dao.UserAndNotes
import com.example.noteappv2.data.entity.NoteEntity
import com.example.noteappv2.utils.ResultState

interface INoteDataSource {
    fun observerAllNotes(): LiveData<ResultState<List<NoteEntity>>>

    fun observerNoteById(noteId: Long): LiveData<ResultState<NoteEntity>>

    suspend fun refreshAllNotes()

    suspend fun getAllNotes(): ResultState<List<NoteEntity>>

    suspend fun getNoteById(noteId: Long): ResultState<NoteEntity>

    suspend fun refreshNoteById(noteId: Long)

    suspend fun saveNote(newNote: NoteEntity)

    suspend fun deleteNoteById(noteId: Long)

    suspend fun deleteAllNotes()

    suspend fun deleteAllNotesOfUserWithId(userId: Long)

    fun observerAllNoteOfUserWithId(userId: Long): LiveData<ResultState<UserAndNotes>>
}
package com.example.noteappv2.data.repository

import androidx.lifecycle.LiveData
import com.example.noteappv2.data.dao.UserAndNotes
import com.example.noteappv2.data.entity.NoteEntity
import com.example.noteappv2.utils.ResultState

interface INoteRepo {
    suspend fun getAllNotes(): ResultState<List<NoteEntity>>

    suspend fun getNoteById(noteId: Long): ResultState<NoteEntity>

    suspend fun saveNote(noteEntity: NoteEntity)

    suspend fun deleteNoteById(noteId: Long)

    suspend fun deleteAllNotes()

    suspend fun addManyNotes(notes: List<NoteEntity>)

    fun observerAllNoteByUserId(userId: Long): LiveData<ResultState<UserAndNotes>>
}
package com.example.noteappv2.data.repository

import com.example.noteappv2.data.entity.NoteEntity
import com.example.noteappv2.utils.ResultState

interface INoteRepo {
    suspend fun getAllNotes(): ResultState<List<NoteEntity>>

    suspend fun getNoteById(noteId: Long): ResultState<NoteEntity>

    suspend fun saveNote(noteEntity: NoteEntity)

    suspend fun deleteNoteById(noteId: Long)

    suspend fun deleteAllNotes()

    suspend fun addManyNotes(notes: List<NoteEntity>)
}
package com.example.noteappv2.data.repository

import com.example.noteappv2.data.datasource.INoteDataSource
import com.example.noteappv2.data.entity.NoteEntity
import com.example.noteappv2.utils.ResultState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class NoteRepositoryImpl(
    private val noteRemoteDataSource: INoteDataSource? = null,
    private val noteLocalDataSource: INoteDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : INoteRepo {
    override suspend fun getAllNotes(): ResultState<List<NoteEntity>> {
        return noteLocalDataSource.getAllNotes()
    }

    override suspend fun getNoteById(noteId: Long): ResultState<NoteEntity> {
        return noteLocalDataSource.getNoteById(noteId)
    }

    override suspend fun saveNote(noteEntity: NoteEntity) {
        noteLocalDataSource.saveNote(noteEntity)
    }

    override suspend fun deleteNoteById(noteId: Long) {
        noteLocalDataSource.deleteNoteById(noteId)
    }

    override suspend fun deleteAllNotes() {
        noteLocalDataSource.deleteAllNotes()
    }
}
package com.example.noteappv2.data.datasource

import androidx.lifecycle.LiveData
import com.example.noteappv2.data.dao.UserAndNotes
import com.example.noteappv2.data.entity.NoteEntity
import com.example.noteappv2.utils.ResultState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class RemoteNoteDataSource(
    private val noteService: Any, // todo create call API from retrofit
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : INoteDataSource {
    override fun observerAllNotes(): LiveData<ResultState<List<NoteEntity>>> {
        TODO("Not yet implemented")
    }

    override fun observerNoteById(noteId: Long): LiveData<ResultState<NoteEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun refreshAllNotes() {
        TODO("Not yet implemented")
    }

    override suspend fun getAllNotes(): ResultState<List<NoteEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun getNoteById(noteId: Long): ResultState<NoteEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun refreshNoteById(noteId: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun saveNote(newNote: NoteEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun saveManyNotes(notes: List<NoteEntity>) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNoteById(noteId: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAllNotes() {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAllNotesOfUserWithId(userId: Long) {
        TODO("Not yet implemented")
    }

    override fun observerAllNoteOfUserWithId(userId: Long): LiveData<ResultState<UserAndNotes>> {
        TODO("Not yet implemented")
    }
}
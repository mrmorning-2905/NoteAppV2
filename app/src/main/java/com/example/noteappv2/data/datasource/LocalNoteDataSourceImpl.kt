package com.example.noteappv2.data.datasource

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.noteappv2.data.dao.NoteDao
import com.example.noteappv2.data.dao.UserAndNotes
import com.example.noteappv2.data.entity.NoteEntity
import com.example.noteappv2.utils.ResultState
import com.example.noteappv2.utils.ResultState.Success
import com.example.noteappv2.utils.ResultState.Error
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalNoteDataSourceImpl(
    private val noteDao: NoteDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : INoteDataSource {
    override fun observerAllNotes(): LiveData<ResultState<List<NoteEntity>>> {
        return noteDao.observerAllNotes().map { Success(it) }
    }

    override fun observerNoteById(noteId: Long): LiveData<ResultState<NoteEntity>> {
        return noteDao.observerNoteById(noteId).map { Success(it) }
    }

    override suspend fun refreshAllNotes() {
        //refresh with RemoteDataSource
    }

    override suspend fun getAllNotes(): ResultState<List<NoteEntity>> = withContext(ioDispatcher) {
        return@withContext try {
            Success(noteDao.getAllNotes())
        } catch (e: Exception) {
            Error(e)
        }
    }

    override suspend fun getNoteById(noteId: Long): ResultState<NoteEntity> = withContext(ioDispatcher) {
        try {
            val curNote = noteDao.findNoteById(noteId)
            if (curNote != null) {
                return@withContext Success(curNote)
            } else {
                return@withContext Error(Exception("Not found any note with noteId: $noteId"))
            }
        } catch (e: Exception) {
            return@withContext Error(e)
        }
    }

    override suspend fun refreshNoteById(noteId: Long) {
        //refresh with RemoteDataSource
    }

    override suspend fun saveNote(newNote: NoteEntity) {
        withContext(ioDispatcher) {
            noteDao.insertOneNote(newNote)
        }
    }

    override suspend fun saveManyNotes(notes: List<NoteEntity>) {
        withContext(ioDispatcher) {
            noteDao.insertManyNotes(notes)
        }
    }

    override suspend fun deleteNoteById(noteId: Long) {
        withContext(ioDispatcher) {
            noteDao.deleteNoteById(noteId)
        }
    }

    override suspend fun deleteAllNotes() {
        withContext(ioDispatcher) {
            noteDao.deleteAllNotes()
        }
    }

    override suspend fun deleteAllNotesOfUserWithId(userId: Long) {
        withContext(ioDispatcher) {
            noteDao.deleteNotesByUId(userId)
        }
    }

    override fun observerAllNoteOfUserWithId(userId: Long): LiveData<ResultState<UserAndNotes>> {
        return noteDao.observerUserAndNotesByUserId(userId).map { Success(it) }
    }

}
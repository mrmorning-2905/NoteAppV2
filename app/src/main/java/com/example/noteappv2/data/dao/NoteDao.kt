package com.example.noteappv2.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.noteappv2.data.entity.NoteEntity

@Dao
interface NoteDao {
    @Query("SELECT * FROM NOTE_TABLE")
    fun observerAllNotes(): LiveData<List<NoteEntity>>

    @Query("SELECT * FROM NOTE_TABLE")
    suspend fun getAllNotes(): List<NoteEntity>

    @Query("SELECT * FROM NOTE_TABLE WHERE note_id = :noteId")
    fun observerNoteById(noteId: Long): LiveData<NoteEntity>

    @Query("SELECT * FROM NOTE_TABLE WHERE note_id = :noteId")
    suspend fun findNoteById(noteId: Long): NoteEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOneNote(newNote: NoteEntity)

    @Insert
    suspend fun insertManyNotes(noteList: List<NoteEntity>)

    @Update
    suspend fun updateNote(note: NoteEntity)

    @Delete
    suspend fun deleteNote(note: NoteEntity)

    @Query("DELETE FROM NOTE_TABLE WHERE note_id = :noteId")
    suspend fun deleteNoteById(noteId: Long)

    @Query("DELETE FROM NOTE_TABLE")
    suspend fun deleteAllNotes()

    @Query("SELECT * FROM USER_TABLE WHERE user_id = :userId")
    @Transaction
    fun observerUserAndNotesByUserId(userId: Long): LiveData<UserAndNotes>

    @Query("DELETE FROM NOTE_TABLE WHERE note_ownerId = :userId")
    suspend fun deleteNotesByUId(userId: Long)
}
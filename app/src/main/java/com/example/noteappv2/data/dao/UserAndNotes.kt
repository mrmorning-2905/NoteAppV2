package com.example.noteappv2.data.dao

import androidx.room.Embedded
import androidx.room.Relation
import com.example.noteappv2.data.entity.NoteEntity
import com.example.noteappv2.data.entity.UserEntity

data class UserAndNotes (
    @Embedded
    val user: UserEntity,

    @Relation(
        parentColumn = "user_id",
        entityColumn = "note_ownerId",
        entity = NoteEntity::class
    )
    val notes: List<NoteEntity>
)
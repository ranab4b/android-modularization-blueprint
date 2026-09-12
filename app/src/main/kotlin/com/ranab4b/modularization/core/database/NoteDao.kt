package com.ranab4b.modularization.core.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes")
    fun getAll(): Flow<List<NoteEntity>>

    @Insert
    suspend fun insert(note: NoteEntity)
}

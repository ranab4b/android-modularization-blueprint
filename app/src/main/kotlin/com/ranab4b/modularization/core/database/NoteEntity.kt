package com.ranab4b.modularization.core.database

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Not used by the demo flow - the app runs on the fake in-memory repository in
 * core-common. This entity exists purely to show where local persistence would live.
 */
@Entity(tableName = "notes")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val text: String,
)

package com.example.saturnus_dimasbudi.pert6.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.saturnus_dimasbudi.pert6.data.entity.NoteEntity

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes ORDER BY id DESC")
    fun getAll(): List<NoteEntity>

    @Insert
    fun insert(note: NoteEntity)

    @Delete
    fun delete(note: NoteEntity)
}

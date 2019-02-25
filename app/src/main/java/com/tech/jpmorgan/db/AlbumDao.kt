package com.tech.jpmorgan.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.tech.jpmorgan.vo.Album

@Dao
interface AlbumDao {

    @Insert
    fun insertAll(albums: List<Album>)

    @Query("SELECT * FROM Album")
    fun getAlbums(): List<Album>

    @Query("SELECT COUNT(*) FROM Album")
    fun count(): Int
}
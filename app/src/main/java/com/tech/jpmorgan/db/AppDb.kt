package com.tech.jpmorgan.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tech.jpmorgan.vo.Album

@Database(
    entities = [Album::class],
    version = 1,
    exportSchema = false)
abstract class AppDb : RoomDatabase() {
    abstract fun albumDao(): AlbumDao
}
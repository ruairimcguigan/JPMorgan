package com.tech.jpmorgan.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [AlbumEntity::class],
    version = 1,
    exportSchema = false)
abstract class AppDb : RoomDatabase() {
    abstract fun albumDao(): AlbumDao
}
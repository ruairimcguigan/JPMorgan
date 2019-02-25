package com.tech.jpmorgan.db

import android.app.Application
import androidx.room.Room
import com.tech.jpmorgan.R
import dagger.Module
import dagger.Provides

@Module
object DbModule {

    @JvmStatic
    @Provides
    fun provideDatabase(application: Application): AppDb {
        return Room.databaseBuilder(
            application.applicationContext,
            AppDb::class.java,
            application.getString(R.string.app_db_name)
        ).build()
    }

    @JvmStatic
    @Provides
    fun provideAlbumDao(appDatabase: AppDb): AlbumDao = appDatabase.albumDao()
}
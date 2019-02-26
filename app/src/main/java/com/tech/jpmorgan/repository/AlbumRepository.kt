package com.tech.jpmorgan.repository

import androidx.lifecycle.LiveData
import com.tech.jpmorgan.api.Api
import com.tech.jpmorgan.db.AlbumDao
import com.tech.jpmorgan.db.AppDb
import com.tech.jpmorgan.util.AppExecutors
import com.tech.jpmorgan.vo.Album
import com.tech.jpmorgan.vo.Resource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AlbumRepository @Inject constructor(
    private val db: AppDb,
    private val appExcecutors: AppExecutors,
    private val albumDao: AlbumDao,
    private val albumApi: Api
) {

    fun fetchAlbums(): LiveData<Resource<List<Album>>> {
        return object : DataResource<List<Album>, List<Album>>(appExcecutors) {

            override fun saveCallResult(albums: List<Album>) {
                albumDao.insertAll(albums)
            }

            override fun shouldFetch(data: List<Album>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun loadFromDb() = albumDao.getAlbums()

            override fun createCall() = albumApi.getAlbums()

            override fun onFetchFailed() {

            }
        }.asLiveData()
    }
}
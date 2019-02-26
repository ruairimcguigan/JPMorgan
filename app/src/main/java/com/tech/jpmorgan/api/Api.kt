package com.tech.jpmorgan.api

import androidx.lifecycle.LiveData
import com.tech.jpmorgan.vo.Album
import retrofit2.http.GET

interface Api {

    @GET("albums")
    fun getAlbums(): LiveData<ApiResponse<List<Album>>>
}
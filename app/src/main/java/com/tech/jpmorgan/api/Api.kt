package com.tech.jpmorgan.api

import androidx.lifecycle.LiveData
import com.tech.jpmorgan.vo.Album
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("albums")
    fun getAlbums(): LiveData<ApiResponse<List<Album>>>
}
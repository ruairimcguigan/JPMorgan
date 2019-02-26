package com.tech.jpmorgan.ui.album

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.tech.jpmorgan.repository.AlbumRepository
import com.tech.jpmorgan.vo.Album
import com.tech.jpmorgan.vo.Resource
import javax.inject.Inject

class AlbumViewModel @Inject constructor(private val repository: AlbumRepository) : ViewModel() {

    fun fetchAlbums(): LiveData<Resource<List<Album>>> = repository.fetchAlbums()
}

package com.tech.jpmorgan.ui.album

import androidx.lifecycle.ViewModel
import com.tech.jpmorgan.vo.Album
import javax.inject.Inject

class AlbumViewModel @Inject constructor() : ViewModel() {

    fun sampleData() = listOf(
        Album("100", "1", "Album one title"),
        Album("101", "2", "Album two title"),
        Album("102", "3", "Album three title"))
}

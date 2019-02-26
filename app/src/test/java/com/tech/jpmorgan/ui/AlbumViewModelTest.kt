package com.tech.jpmorgan.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.tech.jpmorgan.repository.AlbumRepository
import com.tech.jpmorgan.ui.album.AlbumViewModel
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.*

@RunWith(JUnit4::class)
class AlbumViewModelTest {

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private val repository = mock(AlbumRepository::class.java)
    private val viewmodel = AlbumViewModel(repository)


    @Test
    fun testNull() {
        MatcherAssert.assertThat(viewmodel.fetchAlbums(), CoreMatchers.nullValue())
        verify(repository, never()).fetchAlbums()
    }

    @Test
    fun loadRepositories() {
        viewmodel.fetchAlbums()
        verify(repository).fetchAlbums()
    }
}
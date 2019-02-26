package com.tech.jpmorgan.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.tech.jpmorgan.api.Api
import com.tech.jpmorgan.db.AlbumDao
import com.tech.jpmorgan.db.AppDb
import com.tech.jpmorgan.util.InstantAppExecutors
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

@RunWith(JUnit4::class)
class AlbumRepoTest {

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var repository: AlbumRepository
    private val dao = mock(AlbumDao::class.java)
    private val api = mock(Api::class.java)

    @Before
    fun setUp() {
        val db = mock(AppDb::class.java)
        `when`(db.albumDao()).thenReturn(dao)
        `when`(db.runInTransaction(ArgumentMatchers.any())).thenCallRealMethod()
        repository = AlbumRepository(InstantAppExecutors(), dao, api)
    }
}
package com.tech.jpmorgan.injection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tech.jpmorgan.ui.album.AlbumViewModel
import com.tech.jpmorgan.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

//@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(AlbumViewModel::class)
    abstract fun bindAlbumViewModel(albumViewModel: AlbumViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}
package com.tech.jpmorgan.injection

import com.tech.jpmorgan.ui.album.AlbumActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeAlbumActivity(): AlbumActivity
}

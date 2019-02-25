package com.tech.jpmorgan.injection

import com.tech.jpmorgan.ui.album.AlbumFragment

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeRepoFragment(): AlbumFragment
}

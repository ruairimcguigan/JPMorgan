package com.tech.jpmorgan.injection

import com.tech.jpmorgan.ui.album.AlbumActivity
import com.tech.jpmorgan.api.ApiModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    ApiModule::class,
    ViewModelModule::class
])

interface AppComponent {

    fun inject(activity: AlbumActivity)
}
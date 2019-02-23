package com.tech.jpmorgan.injection

import android.content.Context
import android.content.res.Resources
import com.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: App) {

    @Provides
    @Singleton
    fun provideApp() = app

    @Singleton
    @Provides
    fun provideContext(): Context {
        return app.applicationContext
    }

    @Singleton
    @Provides
    fun provideResources(context: Context): Resources {
        return context.resources
    }

}
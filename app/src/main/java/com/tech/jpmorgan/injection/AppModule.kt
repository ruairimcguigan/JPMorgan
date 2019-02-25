package com.tech.jpmorgan.injection

import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideResources(context: Context): Resources {
        return context.resources
    }

}
package com.tech.jpmorgan.injection

import android.app.Application
import com.App
import com.tech.jpmorgan.api.ApiModule
import com.tech.jpmorgan.db.DbModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    ActivityBuildingModule::class,
    ApiModule::class,
    DbModule::class
])

interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: App)
}
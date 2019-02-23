package com

import android.app.Application
import com.tech.jpmorgan.injection.AppComponent
import com.tech.jpmorgan.injection.AppModule
import com.tech.jpmorgan.injection.DaggerAppComponent

class App: Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()

        instance = this
        setup()
    }

    fun setup() {
        component = DaggerAppComponent.builder()
            .appModule(AppModule(this)).build()
    }

    fun getApplicationComponent(): AppComponent {
        return component
    }

    companion object {
        lateinit var instance: App private set
    }
}
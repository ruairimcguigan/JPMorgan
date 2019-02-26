package com.tech.jpmorgan.api

import android.app.Application
import com.tech.jpmorgan.R
import com.tech.jpmorgan.util.LiveDataCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
internal object ApiModule {

    @JvmStatic
    @Provides
    fun okHttpClient(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(Level.BODY))
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(5, TimeUnit.SECONDS)
            .writeTimeout(5, TimeUnit.SECONDS)
        return okHttpClient.build()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideApi(okHttpClient: OkHttpClient,
                             application: Application): Api {
        return Retrofit.Builder()
            .baseUrl(application.getString(R.string.config_api_url))
            .client(okHttpClient)
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }
}
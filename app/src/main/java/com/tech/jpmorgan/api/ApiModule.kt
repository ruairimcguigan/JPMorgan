package com.tech.jpmorgan.api

import android.app.Application
import com.squareup.moshi.Moshi
import com.tech.jpmorgan.R
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.*
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

@Module
internal object ApiModule {

    @JvmStatic
    @Provides
    fun moshi(): Moshi = Moshi.Builder().build()

    @JvmStatic
    @Provides
    fun moshiConverterFactory(moshi: Moshi): Converter.Factory = MoshiConverterFactory.create(moshi)

    @JvmStatic
    @Provides
    fun okHttpClient(apiConfig: ApiConfig): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(Level.BODY))
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(5, TimeUnit.SECONDS)
            .writeTimeout(5, TimeUnit.SECONDS)

        apiConfig.interceptors.map {
            okHttpClient.addInterceptor(it)
        }
        return okHttpClient.build()
    }

    @JvmStatic
    @Provides
    fun provideApi(retrofit: Retrofit): Api = retrofit.create(Api::class.java)

    @JvmStatic
    @Provides
    fun provideRetrofit(
        application: Application,
        okHttpClient: OkHttpClient,
        converter: Converter.Factory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(application.getString(R.string.config_api_url))
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(converter)
            .build()
    }
}
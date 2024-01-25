package com.alhussain.retrofit.di

import com.alhussain.retrofit.BuildConfig
import com.alhussain.retrofit.fake.FakeStore
import com.alhussain.retrofit.interceptors.BasicAuthenticator
import com.alhussain.retrofit.interceptors.CustomHeaderInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Provides
    @Singleton
    fun providesNetworkJson(): Json = Json {
        ignoreUnknownKeys = true
    }

    @Provides
    @Singleton
    fun okHttpCallFactory(fakeStore: FakeStore): Call.Factory =
        OkHttpClient.Builder().addInterceptor(
            HttpLoggingInterceptor().apply {
                if (BuildConfig.DEBUG) {
                    setLevel(HttpLoggingInterceptor.Level.BODY)
                }
            },
        ).addInterceptor(CustomHeaderInterceptor(fakeStore))
            .authenticator(BasicAuthenticator(fakeStore)).build()


}
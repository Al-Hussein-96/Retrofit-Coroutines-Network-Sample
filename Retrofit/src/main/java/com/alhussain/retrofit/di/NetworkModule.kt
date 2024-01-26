package com.alhussain.retrofit.di

import com.alhussain.retrofit.BuildConfig
import com.alhussain.retrofit.datasource.AuthDataSource
import com.alhussain.retrofit.fake.FakeStore
import com.alhussain.retrofit.interceptors.CustomHeaderInterceptor
import com.alhussain.retrofit.interceptors.LoginAuthenticator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AuthOkHttpClient

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class OtherOkHttpClient

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Provides
    @Singleton
    fun providesNetworkJson(): Json = Json {
        ignoreUnknownKeys = true
    }

    @OtherOkHttpClient
    @Provides
    @Singleton
    fun okHttpCallFactory(fakeStore: FakeStore, network: AuthDataSource): Call.Factory =
        OkHttpClient.Builder().addInterceptor(
            HttpLoggingInterceptor().apply {
                if (BuildConfig.DEBUG) {
                    setLevel(HttpLoggingInterceptor.Level.BODY)
                }
            },
        ).addInterceptor(CustomHeaderInterceptor(fakeStore))
            .authenticator(LoginAuthenticator(fakeStore, network)).build()

    @AuthOkHttpClient
    @Provides
    @Singleton
    fun okAuthHttpCallFactory(fakeStore: FakeStore): Call.Factory =
        OkHttpClient.Builder().addInterceptor(
            HttpLoggingInterceptor().apply {
                if (BuildConfig.DEBUG) {
                    setLevel(HttpLoggingInterceptor.Level.BODY)
                }
            },
        ).addInterceptor(CustomHeaderInterceptor(fakeStore)).build()

}
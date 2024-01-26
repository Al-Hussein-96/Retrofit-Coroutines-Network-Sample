package com.alhussain.retrofit

import com.alhussain.retrofit.apis.AuthNetworkApi
import com.alhussain.retrofit.datasource.AuthDataSource
import com.alhussain.retrofit.di.AuthOkHttpClient
import com.alhussain.retrofit.interceptors.safeApiCall
import com.alhussain.retrofit.model.NetworkResponse
import com.alhussain.retrofit.model.NetworkToken
import com.alhussain.retrofit.model.ResultWrapper
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

private const val AXIOM_BASE_URL = BuildConfig.BACKEND_URL


@Singleton
internal class AuthNetwork @Inject constructor(
    networkJson: Json,
    @AuthOkHttpClient okhttpCallFactory: Call.Factory,
) : AuthDataSource {


    private val authApi = Retrofit.Builder()
        .baseUrl(AXIOM_BASE_URL)
        .callFactory(okhttpCallFactory)
        .addConverterFactory(
            networkJson.asConverterFactory("application/json".toMediaType()),
        )
        .build()
        .create(AuthNetworkApi::class.java)

    override suspend fun login(): ResultWrapper<NetworkToken> {
        return safeApiCall(dispatcher = Dispatchers.IO) {
            authApi.login()
        }
    }

}
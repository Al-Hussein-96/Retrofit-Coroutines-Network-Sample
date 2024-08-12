package com.alhussain.retrofit

import com.alhussain.retrofit.apis.RetrofitNetworkApi
import com.alhussain.retrofit.datasource.NetworkDataSource
import com.alhussain.retrofit.interceptors.safeApiCall
import com.alhussain.retrofit.model.ResultWrapper
import com.alhussain.retrofit.model.User
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton


private const val BASE_URL = "https://jsonplaceholder.typicode.com/"


@Singleton
internal class RetrofitNetwork @Inject constructor(
    networkJson: Json,
    okhttpCallFactory: Call.Factory,
) : NetworkDataSource {


    private val networkApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .callFactory(okhttpCallFactory)
        .addConverterFactory(
            networkJson.asConverterFactory("application/json".toMediaType()),
        )
        .build()
        .create(RetrofitNetworkApi::class.java)

    override suspend fun getAllUsers(): ResultWrapper<List<User>> {
        return safeApiCall(Dispatchers.IO) {
            networkApi.getAllUsers()
        }
    }


}

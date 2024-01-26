package com.alhussain.retrofit

import com.alhussain.retrofit.apis.AuthNetworkApi
import com.alhussain.retrofit.apis.RetrofitAxiomNetworkApi
import com.alhussain.retrofit.datasource.AxiomNetworkDataSource
import com.alhussain.retrofit.di.OtherOkHttpClient
import com.alhussain.retrofit.interceptors.safeApiCall
import com.alhussain.retrofit.model.NetworkCustomer
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
internal class RetrofitAxiomNetwork @Inject constructor(
    networkJson: Json,
    @OtherOkHttpClient okhttpCallFactory: Call.Factory,
) : AxiomNetworkDataSource {

    private val authApi = Retrofit.Builder()
        .baseUrl(AXIOM_BASE_URL)
        .callFactory(okhttpCallFactory)
        .addConverterFactory(
            networkJson.asConverterFactory("application/json".toMediaType()),
        )
        .build()
        .create(RetrofitAxiomNetworkApi::class.java)


    private val networkApi = Retrofit.Builder()
        .baseUrl(AXIOM_BASE_URL)
        .callFactory(okhttpCallFactory)
        .addConverterFactory(
            networkJson.asConverterFactory("application/json".toMediaType()),
        )
        .build()
        .create(RetrofitAxiomNetworkApi::class.java)


    override suspend fun login(): ResultWrapper<NetworkToken> {
        return safeApiCall(dispatcher = Dispatchers.IO) {
            authApi.login()
        }
    }

    override suspend fun getCustomerInfoByIMEI(imei: String): NetworkResponse<NetworkCustomer> =
        networkApi.getCustomerInfoByIMEI(imei)

    override suspend fun syncDevice(deviceId: String): ResultWrapper<NetworkResponse<NetworkCustomer>> {
        return safeApiCall(dispatcher = Dispatchers.IO) {
            networkApi.syncDevice(deviceId)
        }
    }


}
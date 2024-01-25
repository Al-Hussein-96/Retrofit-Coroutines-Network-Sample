package com.alhussain.retrofit

import com.alhussain.retrofit.apis.RetrofitAxiomNetworkApi
import com.alhussain.retrofit.datasource.AxiomNetworkDataSource
import com.alhussain.retrofit.model.NetworkCustomer
import com.alhussain.retrofit.model.NetworkResponse
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
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
    okhttpCallFactory: Call.Factory,
) : AxiomNetworkDataSource {
    private val networkApi = Retrofit.Builder()
        .baseUrl(AXIOM_BASE_URL)
        .callFactory(okhttpCallFactory)
        .addConverterFactory(
            networkJson.asConverterFactory("application/json".toMediaType()),
        )
        .build()
        .create(RetrofitAxiomNetworkApi::class.java)


    override suspend fun getCustomerInfoByIMEI(imei: String): NetworkResponse<NetworkCustomer> =
        networkApi.getCustomerInfoByIMEI(imei)


}
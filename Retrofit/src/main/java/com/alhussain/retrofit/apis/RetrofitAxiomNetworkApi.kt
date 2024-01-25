package com.alhussain.retrofit.apis

import com.alhussain.retrofit.model.NetworkCustomer
import com.alhussain.retrofit.model.NetworkResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

internal interface RetrofitAxiomNetworkApi {

    @GET(value = "customer/device/{IMEI}")
    suspend fun getCustomerInfoByIMEI(
        @Path("IMEI") imei: String,
    ): NetworkResponse<NetworkCustomer>


    @GET(value = "sync/{deviceId}")
    suspend fun syncDevice(
        @Path("deviceId") deviceId: String,
    ): NetworkResponse<NetworkCustomer>

}
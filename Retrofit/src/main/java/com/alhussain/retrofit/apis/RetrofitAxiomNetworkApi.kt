package com.alhussain.retrofit.apis

import com.alhussain.retrofit.model.NetworkCatalogs
import com.alhussain.retrofit.model.NetworkCustomer
import com.alhussain.retrofit.model.NetworkResponse
import com.alhussain.retrofit.model.NetworkSyncedDevice
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
    ): NetworkSyncedDevice


    @GET(value = "catalog/{customerGroup}")
    suspend fun getCatalogs(
        @Path("customerGroup") customerGroup: Int,
    ): NetworkCatalogs


}
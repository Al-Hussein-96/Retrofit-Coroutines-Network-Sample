package com.alhussain.retrofit.apis

import com.alhussain.retrofit.model.NetworkAppUpdate
import com.alhussain.retrofit.model.NetworkCatalogs
import com.alhussain.retrofit.model.NetworkCustomer
import com.alhussain.retrofit.model.NetworkOrder
import com.alhussain.retrofit.model.NetworkResponse
import com.alhussain.retrofit.model.NetworkServerStatus
import com.alhussain.retrofit.model.NetworkSyncedDevice
import com.alhussain.retrofit.model.NetworkTemplates
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
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

    @GET(value = "catalog/template")
    suspend fun getTemplates(): NetworkResponse<NetworkTemplates>


    @GET(value = "status")
    suspend fun getServerStatus(): NetworkServerStatus

    @POST(value = "ver")
    suspend fun getAppUpdate(@Body request: NetworkAppUpdate.NetworkAppUpdateRequest): NetworkAppUpdate


    @POST(value = "order")
    suspend fun order(@Body request: NetworkOrder.NetworkOrderRequest): NetworkOrder


}
package com.alhussain.retrofit.apis

import com.alhussain.retrofit.model.ClaimRequest
import com.alhussain.retrofit.model.ClaimsRequest
import com.alhussain.retrofit.model.ConfirmOrderRequest
import com.alhussain.retrofit.model.DingOrderRequest
import com.alhussain.retrofit.model.EmposOrderRequest
import com.alhussain.retrofit.model.FulfilledDingOrderRequest
import com.alhussain.retrofit.model.NetworkAppUpdate
import com.alhussain.retrofit.model.NetworkCatalogs
import com.alhussain.retrofit.model.NetworkClaimResult
import com.alhussain.retrofit.model.NetworkClaims
import com.alhussain.retrofit.model.NetworkCustomer
import com.alhussain.retrofit.model.NetworkDingResult
import com.alhussain.retrofit.model.NetworkFulfilledDingOrder
import com.alhussain.retrofit.model.NetworkFulfilledOrder
import com.alhussain.retrofit.model.NetworkOrder
import com.alhussain.retrofit.model.NetworkOrders
import com.alhussain.retrofit.model.NetworkResponse
import com.alhussain.retrofit.model.NetworkServerStatus
import com.alhussain.retrofit.model.NetworkSyncedDevice
import com.alhussain.retrofit.model.NetworkTemplates
import com.alhussain.retrofit.model.OrdersRequest
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


    @GET(value = "order/pos/{reqId}")
    suspend fun fulfilledOrder(@Path("reqId") reqId: String): NetworkFulfilledOrder

    @POST(value = "order/confirm")
    suspend fun confirmOrder(@Body request: ConfirmOrderRequest): NetworkResponse<Unit>


    @POST(value = "order/dev/list")
    suspend fun getOrders(@Body request: OrdersRequest): NetworkOrders


    @POST(value = "order/ding/account")
    suspend fun dingLookup(@Body request: DingOrderRequest): NetworkDingResult


    @POST(value = "order/ding/pos/send")
    suspend fun fulfilledDingOrder(@Body request: FulfilledDingOrderRequest): NetworkFulfilledDingOrder


    @POST(value = "order/ding/pos/send")
    suspend fun fulfilledEmposOrder(@Body request: EmposOrderRequest): NetworkFulfilledDingOrder


    @POST(value = "order/claim")
    suspend fun requestClaim(@Body request: ClaimRequest): NetworkClaimResult

    @POST(value = "order/claim/list")
    suspend fun getClaims(@Body request: ClaimsRequest): NetworkClaims


}
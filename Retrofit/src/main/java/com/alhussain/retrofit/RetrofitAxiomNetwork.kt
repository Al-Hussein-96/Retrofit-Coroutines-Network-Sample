package com.alhussain.retrofit

import com.alhussain.retrofit.apis.RetrofitAxiomNetworkApi
import com.alhussain.retrofit.datasource.AxiomNetworkDataSource
import com.alhussain.retrofit.di.OtherOkHttpClient
import com.alhussain.retrofit.interceptors.safeApiCall
import com.alhussain.retrofit.model.ClaimRequest
import com.alhussain.retrofit.model.ConfirmOrderRequest
import com.alhussain.retrofit.model.DingOrderRequest
import com.alhussain.retrofit.model.EmposOrderRequest
import com.alhussain.retrofit.model.FulfilledDingOrderRequest
import com.alhussain.retrofit.model.NetworkAppUpdate
import com.alhussain.retrofit.model.NetworkCatalogs
import com.alhussain.retrofit.model.NetworkClaim
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


    private val networkApi = Retrofit.Builder()
        .baseUrl(AXIOM_BASE_URL)
        .callFactory(okhttpCallFactory)
        .addConverterFactory(
            networkJson.asConverterFactory("application/json".toMediaType()),
        )
        .build()
        .create(RetrofitAxiomNetworkApi::class.java)


    override suspend fun getCustomerInfoByIMEI(imei: String): ResultWrapper<NetworkResponse<NetworkCustomer>> {
        return safeApiCall(dispatcher = Dispatchers.IO) {
            networkApi.getCustomerInfoByIMEI(imei)
        }
    }


    override suspend fun syncDevice(deviceId: String): ResultWrapper<NetworkSyncedDevice> {
        return safeApiCall(dispatcher = Dispatchers.IO) {
            networkApi.syncDevice(deviceId)
        }
    }

    override suspend fun getCatalogs(customerGroup: Int): ResultWrapper<NetworkCatalogs> {
        return safeApiCall(dispatcher = Dispatchers.IO) {
            networkApi.getCatalogs(customerGroup)
        }
    }

    override suspend fun getTemplates(): ResultWrapper<NetworkResponse<NetworkTemplates>> {
        return safeApiCall(dispatcher = Dispatchers.IO) {
            networkApi.getTemplates()
        }
    }

    override suspend fun getAppUpdate(request: NetworkAppUpdate.NetworkAppUpdateRequest): ResultWrapper<NetworkAppUpdate> {
        return safeApiCall(dispatcher = Dispatchers.IO) {
            networkApi.getAppUpdate(request)
        }
    }

    override suspend fun order(request: NetworkOrder.NetworkOrderRequest): ResultWrapper<NetworkOrder> {
        return safeApiCall(dispatcher = Dispatchers.IO) {
            networkApi.order(request)
        }
    }

    override suspend fun fulfilledOrder(reqId: String): ResultWrapper<NetworkFulfilledOrder> {
        return safeApiCall(dispatcher = Dispatchers.IO) {
            networkApi.fulfilledOrder(reqId = reqId)
        }
    }

    override suspend fun confirmOrder(request: ConfirmOrderRequest): ResultWrapper<NetworkResponse<Unit>> {
        return safeApiCall(dispatcher = Dispatchers.IO) {
            networkApi.confirmOrder(request = request)
        }
    }

    override suspend fun getOrders(request: OrdersRequest): ResultWrapper<NetworkOrders> {
        return safeApiCall(dispatcher = Dispatchers.IO) {
            networkApi.getOrders(request = request)
        }
    }

    override suspend fun dingLookup(request: DingOrderRequest): ResultWrapper<NetworkDingResult> {
        return safeApiCall(dispatcher = Dispatchers.IO) {
            networkApi.dingLookup(request = request)
        }
    }

    override suspend fun fulfilledDingOrder(request: FulfilledDingOrderRequest): ResultWrapper<NetworkFulfilledDingOrder> {
        return safeApiCall(dispatcher = Dispatchers.IO) {
            networkApi.fulfilledDingOrder(request = request)
        }
    }

    override suspend fun fulfilledEmposOrder(request: EmposOrderRequest): ResultWrapper<NetworkFulfilledDingOrder> {
        return safeApiCall(dispatcher = Dispatchers.IO) {
            networkApi.fulfilledEmposOrder(request = request)
        }
    }

    override suspend fun requestClaim(request: ClaimRequest): ResultWrapper<NetworkClaim> {
        return safeApiCall(dispatcher = Dispatchers.IO) {
            networkApi.requestClaim(request = request)
        }
    }

    override suspend fun getServerStatus(): ResultWrapper<NetworkServerStatus> {
        return safeApiCall(dispatcher = Dispatchers.IO) {
            networkApi.getServerStatus()
        }
    }

}
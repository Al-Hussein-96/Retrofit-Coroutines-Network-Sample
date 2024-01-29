package com.alhussain.retrofit.datasource

import com.alhussain.retrofit.model.ConfirmOrderRequest
import com.alhussain.retrofit.model.DingOrderRequest
import com.alhussain.retrofit.model.EmposOrderRequest
import com.alhussain.retrofit.model.FulfilledDingOrderRequest
import com.alhussain.retrofit.model.NetworkAppUpdate
import com.alhussain.retrofit.model.NetworkCatalogs
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

interface AxiomNetworkDataSource {


    suspend fun getCustomerInfoByIMEI(imei: String): ResultWrapper<NetworkResponse<NetworkCustomer>>
    suspend fun syncDevice(deviceId: String): ResultWrapper<NetworkSyncedDevice>
    suspend fun getCatalogs(customerGroup: Int): ResultWrapper<NetworkCatalogs>
    suspend fun getTemplates(): ResultWrapper<NetworkResponse<NetworkTemplates>>
    suspend fun getServerStatus(): ResultWrapper<NetworkServerStatus>
    suspend fun getAppUpdate(request: NetworkAppUpdate.NetworkAppUpdateRequest): ResultWrapper<NetworkAppUpdate>
    suspend fun order(request: NetworkOrder.NetworkOrderRequest): ResultWrapper<NetworkOrder>
    suspend fun fulfilledOrder(reqId: String): ResultWrapper<NetworkFulfilledOrder>
    suspend fun confirmOrder(request: ConfirmOrderRequest): ResultWrapper<NetworkResponse<Unit>>
    suspend fun getOrders(request: OrdersRequest): ResultWrapper<NetworkOrders>
    suspend fun dingLookup(request: DingOrderRequest): ResultWrapper<NetworkDingResult>
    suspend fun fulfilledDingOrder(request: FulfilledDingOrderRequest): ResultWrapper<NetworkFulfilledDingOrder>
    suspend fun fulfilledEmposOrder(request: EmposOrderRequest): ResultWrapper<NetworkFulfilledDingOrder>

}
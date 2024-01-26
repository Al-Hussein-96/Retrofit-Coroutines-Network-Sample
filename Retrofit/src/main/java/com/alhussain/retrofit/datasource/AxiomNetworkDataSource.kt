package com.alhussain.retrofit.datasource

import com.alhussain.retrofit.model.NetworkCatalogs
import com.alhussain.retrofit.model.NetworkCustomer
import com.alhussain.retrofit.model.NetworkResponse
import com.alhussain.retrofit.model.NetworkSyncedDevice
import com.alhussain.retrofit.model.NetworkTemplates
import com.alhussain.retrofit.model.ResultWrapper

interface AxiomNetworkDataSource {


    suspend fun getCustomerInfoByIMEI(imei: String): ResultWrapper<NetworkResponse<NetworkCustomer>>
    suspend fun syncDevice(deviceId: String): ResultWrapper<NetworkSyncedDevice>
    suspend fun getCatalogs(customerGroup: Int): ResultWrapper<NetworkCatalogs>
    suspend fun getTemplates(): ResultWrapper<NetworkResponse<NetworkTemplates>>
}
package com.alhussain.retrofit.datasource

import com.alhussain.retrofit.model.NetworkCustomer
import com.alhussain.retrofit.model.NetworkResponse
import com.alhussain.retrofit.model.ResultWrapper
import retrofit2.Response

interface AxiomNetworkDataSource {

    suspend fun getCustomerInfoByIMEI(imei: String): NetworkResponse<NetworkCustomer>
    suspend fun syncDevice(deviceId: String): ResultWrapper<NetworkResponse<NetworkCustomer>>
}
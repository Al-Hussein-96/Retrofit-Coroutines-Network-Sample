package com.alhussain.retrofit.datasource

import com.alhussain.retrofit.model.NetworkCustomer
import com.alhussain.retrofit.model.NetworkResponse
import com.alhussain.retrofit.model.NetworkToken
import com.alhussain.retrofit.model.ResultWrapper

interface AxiomNetworkDataSource {

    suspend fun login(): ResultWrapper<NetworkToken>


    suspend fun getCustomerInfoByIMEI(imei: String): NetworkResponse<NetworkCustomer>
    suspend fun syncDevice(deviceId: String): ResultWrapper<NetworkResponse<NetworkCustomer>>
}
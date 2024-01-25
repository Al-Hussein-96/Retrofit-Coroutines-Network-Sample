package com.alhussain.retrofit.datasource

import com.alhussain.retrofit.model.NetworkCustomer
import com.alhussain.retrofit.model.NetworkResponse

interface AxiomNetworkDataSource {

    suspend fun getCustomerInfoByIMEI(imei: String): NetworkResponse<NetworkCustomer>
}
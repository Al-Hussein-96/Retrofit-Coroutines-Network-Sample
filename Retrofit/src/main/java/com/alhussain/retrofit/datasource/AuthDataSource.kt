package com.alhussain.retrofit.datasource

import com.alhussain.retrofit.model.NetworkCustomer
import com.alhussain.retrofit.model.NetworkResponse
import com.alhussain.retrofit.model.NetworkToken
import com.alhussain.retrofit.model.ResultWrapper

interface AuthDataSource {

    suspend fun login(): ResultWrapper<NetworkToken>
}
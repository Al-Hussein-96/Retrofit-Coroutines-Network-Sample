package com.alhussain.retrofit.datasource

import com.alhussain.retrofit.model.ResultWrapper
import com.alhussain.retrofit.model.User

interface NetworkDataSource {


    suspend fun getAllUsers(): ResultWrapper<List<User>>


}
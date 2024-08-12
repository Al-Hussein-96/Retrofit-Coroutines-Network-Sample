package com.alhussain.retrofit.apis

import com.alhussain.retrofit.model.User
import retrofit2.http.GET

internal interface RetrofitNetworkApi {

    @GET(value = "users")
    suspend fun getAllUsers(
    ): List<User>


}
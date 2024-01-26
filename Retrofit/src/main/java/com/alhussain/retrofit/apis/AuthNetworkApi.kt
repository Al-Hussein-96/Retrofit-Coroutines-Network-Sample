package com.alhussain.retrofit.apis

import android.media.session.MediaSession.Token
import com.alhussain.retrofit.model.NetworkCustomer
import com.alhussain.retrofit.model.NetworkResponse
import com.alhussain.retrofit.model.NetworkToken
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

internal interface AuthNetworkApi {

    @POST(value = "login")
    suspend fun login(): NetworkToken

}
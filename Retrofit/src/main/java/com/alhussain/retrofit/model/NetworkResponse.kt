package com.alhussain.retrofit.model

import kotlinx.serialization.Serializable
import retrofit2.Response


@Serializable
data class NetworkResponse<T>(
    val data: T? = null,
    val status: String?
)
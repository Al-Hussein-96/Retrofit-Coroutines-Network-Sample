package com.alhussain.retrofit.model

import kotlinx.serialization.Serializable


@Serializable
data class NetworkResponse<T>(
    val data: T? = null,
    val status: String
)
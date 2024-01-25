package com.alhussain.retrofit.model

import kotlinx.serialization.Serializable


@Serializable
data class ServerError(
    val desc: String? = null,
    val error: String? = null,
    val errno: Int? = null,
    val status: String
)
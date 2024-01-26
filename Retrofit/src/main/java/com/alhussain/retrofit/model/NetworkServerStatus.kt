package com.alhussain.retrofit.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkServerStatus(
    val status: String,
    val message: String,
    val to: String
)

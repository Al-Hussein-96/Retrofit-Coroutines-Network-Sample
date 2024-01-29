package com.alhussain.retrofit.model

import kotlinx.serialization.Serializable

@Serializable
data class ClaimsRequest(
    val fromdate: String,
    val todate: String,
    val pinSerial: String = ""
)

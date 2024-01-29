package com.alhussain.retrofit.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OrdersRequest(
    @SerialName("deviceId") val deviceid: String,
    val type: String,
    val all: String = "no",
    @SerialName("Offset") val offset: Int,
    @SerialName("Limit") val limit: Int,
    val fromdate: String,
    val todate: String,
    val orderType: String = "ONLINE"
)

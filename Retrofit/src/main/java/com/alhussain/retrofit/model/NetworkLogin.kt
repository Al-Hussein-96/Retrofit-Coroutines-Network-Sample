package com.alhussain.retrofit.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkLogin(
    @SerialName("Cashier_id") val cashierId: Long,
    @SerialName("Cashier_pin") val cashierPin: Int,
    @SerialName("Device_id") val deviceId: String,
)

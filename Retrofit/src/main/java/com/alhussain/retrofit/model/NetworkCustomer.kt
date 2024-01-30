package com.alhussain.retrofit.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkCustomer(
    @SerialName("customerid") val customerId: String,
    @SerialName("clientsecret") val clientSecret: String,
    @SerialName("deviceid") val deviceId: String,
    @SerialName("cashierid") val cashierId: Int,
    @SerialName("cashierpin") val cashierPin: Int,
    @SerialName("serverurl") val serverUrl: String,
)

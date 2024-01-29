package com.alhussain.retrofit.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkOrders(
    @SerialName("Orders") val orders: List<NetworkOrderData>
)

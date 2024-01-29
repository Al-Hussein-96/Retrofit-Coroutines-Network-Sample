package com.alhussain.retrofit.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

interface INetworkOrderRequest {
    @SerialName("customerid")
    val customerId: String
    @SerialName("deviceid")
    val deviceId: String
    @SerialName("cashierid")
    val cashierId: Long
    @SerialName("customerref")
    val customerRef: String
    @SerialName("Type")
    val type: String
    @SerialName("Origin")
    val origin: String
    val items: List<ItemRequest>

    @Serializable
    data class ItemRequest(
        @SerialName("productid") val productId: Int,
        val qty: Int,
        val amount: Double? = null,
    )
}

package com.alhussain.retrofit.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class NetworkOrder(
    val stauts: String,
    val desc: String,
    @SerialName("reqid") val reqId: String
) {
    @Serializable
    data class NetworkOrderRequest(
        @SerialName("customerid") val customerId: String,
        @SerialName("deviceid") val deviceId: String,
        @SerialName("cashierid") val cashierId: Long,
        @SerialName("customerref") val customerRef: String,
        @SerialName("Type") val type: String,
        @SerialName("Origin") val origin: String,
        val items: List<ItemRequest>
    ) {
        @Serializable
        data class ItemRequest(
            @SerialName("productid") val productId: Int,
            val qty: Int
        )
    }
}

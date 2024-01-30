package com.alhussain.retrofit.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class NetworkOrder(
    val status: String,
    val desc: String,
    @SerialName("reqid") val reqId: String
) {
    @Serializable
    data class NetworkOrderRequest(
        override val customerId: String,
        override val deviceId: String,
        override val cashierId: Long,
        override val customerRef: String,
        override val type: String,
        override val origin: String,
        override val items: List<INetworkOrderRequest.ItemRequest>
    ) : INetworkOrderRequest
}

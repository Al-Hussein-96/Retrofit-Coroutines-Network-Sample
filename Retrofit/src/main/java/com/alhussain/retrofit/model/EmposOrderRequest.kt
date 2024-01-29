package com.alhussain.retrofit.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EmposOrderRequest(
    override val customerId: String,
    override val deviceId: String,
    override val cashierId: Long,
    override val customerRef: String,
    override val type: String = "TOPUP",
    override val origin: String,
    override val items: List<INetworkOrderRequest.ItemRequest>,
    val accountRequest: EmposOrderRequest.AccountRequest
) : INetworkOrderRequest {
    @Serializable
    data class AccountRequest(
        @SerialName("MSISDN") val msisdn: String,
        @SerialName("amount") val amount: Double,
        @SerialName("subtype") val subtype: String? = null,
    )
}


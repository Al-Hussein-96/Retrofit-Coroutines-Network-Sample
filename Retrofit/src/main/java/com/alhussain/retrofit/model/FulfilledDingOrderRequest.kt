package com.alhussain.retrofit.model

import kotlinx.serialization.Serializable

@Serializable
data class FulfilledDingOrderRequest(
    override val customerId: String,
    override val deviceId: String,
    override val cashierId: Long,
    override val customerRef: String,
    override val type: String,
    override val origin: String,
    override val items: List<INetworkOrderRequest.ItemRequest>,
    val dingRequest: DingRequest
) : INetworkOrderRequest {
    @Serializable
    data class DingRequest(
        val accountNumber: String,
        val distributorRef: String,
        val providerCode: String,
        val sendCurrencyIso: String,
        val sendValue: Double,
        val skuCode: String,
        val validateOnly: String,
    )
}




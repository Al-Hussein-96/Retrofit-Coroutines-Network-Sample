package com.alhussain.retrofit.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@OptIn(ExperimentalSerializationApi::class)

@Serializable
data class NetworkFulfilledDingOrder(
    @JsonNames("ReqId", "reqid") override val reqId: String,
    @JsonNames("Action", "action") override val action: String,
    @JsonNames("Desc", "desc") override val desc: String,
    @JsonNames("Status", "status") override val status: String,
    val data: String,
) : INetworkFulfilledOrder

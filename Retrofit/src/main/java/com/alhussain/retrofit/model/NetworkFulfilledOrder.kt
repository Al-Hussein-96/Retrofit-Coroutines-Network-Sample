package com.alhussain.retrofit.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@Serializable
data class NetworkFulfilledOrder @OptIn(ExperimentalSerializationApi::class) constructor(
    @JsonNames("ReqId", "reqid") override val reqId: String? = null,
    @JsonNames("Action", "action") override val action: String,
    @JsonNames("Desc", "desc") override val desc: String,
    @JsonNames("Status", "status") override val status: String,
    @JsonNames("Data") val data: NetworkOrderData? = null,
) : INetworkFulfilledOrder {

    val shouldRetry: Boolean = status.equals("success", true) && action.equals("Pending", true)
}

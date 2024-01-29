package com.alhussain.retrofit.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkFulfilledOrder(
    @SerialName("ReqId") val reqId: String,
    @SerialName("Action") val action: String,
    @SerialName("Desc") val desc: String,
    @SerialName("Status") val status: String,
    @SerialName("Data") val data: NetworkOrderData,


    ) {

}

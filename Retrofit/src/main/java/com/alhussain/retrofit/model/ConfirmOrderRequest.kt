package com.alhussain.retrofit.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfirmOrderRequest(
    @SerialName("reqid") val reqId: String,
    @SerialName("cashierid") val cashierId: Long,
    val type: String,
    val status: String,
    @SerialName("pinserial") val pinSerial: String,
 )

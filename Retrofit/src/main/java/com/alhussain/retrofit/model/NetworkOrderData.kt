package com.alhussain.retrofit.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkOrderData(
    @SerialName("ReqId") val reqId: String,
    @SerialName("OrderId") val orderId: Long,
    @SerialName("Type") val type: String,
    @SerialName("DeviceId") val deviceId: String,
    @SerialName("CustomerId") val customerId: String,
    @SerialName("Status") val status: String,
    @SerialName("NewBalance") val newBalance: Double? = null,
    @SerialName("CreateAt") val createdAt: String,
    @SerialName("ticketdata") val networkticketInfo: NetworkTicketInfo,
    @SerialName("Items") val items: List<NetworkOrderItem>,
) {
    @Serializable

    data class NetworkTicketInfo(
        val provider: String,
        @SerialName("trxid") val trxId: Long,
        val tax: Long? = null,
        val received: Double? = null,
        val ref: String,
        val ean: String,
        val exterminal: String
    )

    @Serializable

    data class NetworkOrderItem(
        @SerialName("ListPrice") val listPrice: Double,
        @SerialName("PinItems") val pinItems: List<NetworkPinItem>,

        ) {

        @Serializable
        data class NetworkPinItem(
            @SerialName("PinSerial") val pinSerial: String? = null,
            @SerialName("PinCode") val pinCode: String? = null,
            @SerialName("PinExpiry") val pinExpiry: String? = null,
            @SerialName("Status") val status: String,
        )

    }
}


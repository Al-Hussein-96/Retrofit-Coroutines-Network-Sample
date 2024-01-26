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
    @Serializable
    data class NetworkOrderData(
        @SerialName("ReqId") val reqId: String,
        @SerialName("OrderId") val orderId: Long,
        @SerialName("Type") val type: String,
        @SerialName("DeviceId") val deviceId: String,
        @SerialName("CustomerId") val customerId: String,
        @SerialName("Status") val status: String,
        @SerialName("NewBalance") val newBalance: Double,
        @SerialName("CreatedAt") val createdAt: String,
        @SerialName("ticketdata") val networkticketInfo: NetworkTicketInfo,
        @SerialName("Items") val items: List<NetworkOrderItem>,
    ) {
        @Serializable

        data class NetworkTicketInfo(
            val provider: String,
            val trxId: Long,
            val tax: Long,
            val received: Double,
            val ref: String,
            val ean: String,
            val exterminal: String
        )

        @Serializable

        data class NetworkOrderItem(
            @SerialName("ReqId") val reqId: String,
            @SerialName("ListPrice") val listPrice: Double,
            @SerialName("PinItems") val pinItems: List<NetworkPinItem>,

            ) {

            @Serializable
            data class NetworkPinItem(
                @SerialName("PinSerial") val pinSerial: String,
                @SerialName("PinCode") val pinCode: Double,
                @SerialName("PinExpiry") val pinExpiry: Double,
                @SerialName("Status") val status: Double,
            )

        }
    }

}

package com.alhussain.retrofit.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkSyncedDevice(
    val customer: String,
    val group: Int,
    val type: String,
    val balance: Double,
    val active: String,
    @SerialName("wallettype") val walleTtype: String,
    @SerialName("creditlimit") val creditLimit: String,
    @SerialName("walletstatus") val walletStatus: String,
    val cashiers: List<NetworkCashier>,
) {
    @Serializable
    data class NetworkCashier(
        val name: String,
        @SerialName("CashierID") val cashierId: Int,
        @SerialName("PIN") val pin: Int,
        @SerialName("IsAdmin") val isAdmin: String,
    )
}

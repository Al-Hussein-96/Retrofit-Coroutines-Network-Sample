package com.alhussain.retrofit.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkProduct(
    val productId: Int,
    val type: String,
    val descEn: String,
    val listprice: Double,
    val providerId: Int,
    val logo: String,
    val templateId: String,
    val active: String,
    val name: String,
    val subtype: String,
    val products: List<NetworkDenomination>
) {
    @Serializable
    data class NetworkDenomination(
        val amount: Int,
        val name: String,
    )
}
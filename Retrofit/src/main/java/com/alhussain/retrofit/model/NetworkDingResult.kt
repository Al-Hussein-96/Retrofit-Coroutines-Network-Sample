package com.alhussain.retrofit.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable

data class NetworkDingResult(
    val status: String, val desc: String, val data: NetworkDingData
) {
    @Serializable

    data class NetworkDingData(
        @SerialName("productsLst") val productList: List<ProductDing>,
    ) {
        @Serializable
        data class ProductDing(
            val productType: String,
            val items: List<ProductDingItem>,
        ) {
            @Serializable
            data class ProductDingItem(
                val maximum: NetworkDingVal,
                val minimum: NetworkDingVal,
                val providerCode: String,
                val skuCode: String,
                val amount: Double? = null,
                val productsDescriptionText: String? = null
            )
        }
    }

    @Serializable
    data class NetworkDingVal(
        val receiveCurrencyIso: String,
        val receiveValue: Double,
        val sendCurrencyIso: String,
        val sendValue: Double
    )
}

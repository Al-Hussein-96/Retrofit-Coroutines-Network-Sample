package com.alhussain.retrofit.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkClaims(
    @SerialName("CustomerId") val customerId: String,
    @SerialName("Status") val status: String,
    @SerialName("Claims") val claims: List<ClaimData>
) {
    @Serializable
    data class ClaimData(
        @SerialName("CreateAt") val createdAt: String,
        @SerialName("Pinserial") val pinSerial: String,
        @SerialName("Status") val status: String,
        @SerialName("productdetails") val productDetails: ProductDetails,
    ) {
        @Serializable
        data class ProductDetails(val descEn: String? = null)
    }
}

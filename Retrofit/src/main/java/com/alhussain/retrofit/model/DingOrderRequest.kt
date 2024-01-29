package com.alhussain.retrofit.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DingOrderRequest(
    @SerialName("AccountRequest") val accountRequest: AccountRequest,
    @SerialName("Type") val type: String,
) {
    @Serializable
    data class AccountRequest(
        @SerialName("number") val number: String,
        @SerialName("Benefits") val benefits: String? = null,
    )
}


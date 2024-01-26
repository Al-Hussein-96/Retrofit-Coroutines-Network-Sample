package com.alhussain.retrofit.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkToken(
    @SerialName("Token") val token: TokenData,

    ) {

    @Serializable
    data class TokenData(@SerialName("access_token") val accessToken: String)
}

package com.alhussain.retrofit.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkAppUpdate(
    val action: String,
    val url: String,
    @SerialName("forcesync") val forceSync: String
) {
    @Serializable
    data class NetworkAppUpdateRequest(
        val appid: String,
        val ver: String,
        val deviceid: String,
        val latitude: Double = 0.0,
        val longitude: Double = 0.0,
        @SerialName("forcesync") val forceSync: String = ""
    )

}


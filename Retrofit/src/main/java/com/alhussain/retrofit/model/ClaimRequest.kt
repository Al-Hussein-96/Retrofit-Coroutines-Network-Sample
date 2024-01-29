package com.alhussain.retrofit.model

import kotlinx.serialization.Serializable


@Serializable
data class ClaimRequest(
    val data: String,
    val orderRef: Long,
    val pinSerial: String,
    val source: String,
    val type: String
)

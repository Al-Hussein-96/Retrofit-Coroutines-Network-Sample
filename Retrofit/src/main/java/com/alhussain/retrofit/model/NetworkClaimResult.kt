package com.alhussain.retrofit.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkClaimResult(
   @SerialName("ClaimId") val claimId: String,
   @SerialName("Created") val created: String,
   @SerialName("status") val status: String
)

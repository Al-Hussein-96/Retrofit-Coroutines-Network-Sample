package com.alhussain.retrofit.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkTemplates(val templates: List<NetworkTemplate>) {

    @Serializable
    data class NetworkTemplate(
        val id: Int,
        val template: String
    )
}

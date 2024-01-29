package com.alhussain.retrofit.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkCatalogs(
    val catalogs: List<NetworkCatalog>
) {
    @Serializable
    data class NetworkCatalog(
        val providers: List<NetworkProvider>
    ) {
        @Serializable
        data class NetworkProvider(
            val providerId: Int,
            val descEng: String,
            val active: String,
            val logo: String,
            val providerGroupId: String,
            val providerGroupName: String,
            val products: List<NetworkProduct>
        )
    }
}
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
        ) {
            @Serializable
            data class NetworkProduct(
                val productId: Int,
                val type: String,
                val descEn: String,
                val listprice: String,
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
        }
    }
}
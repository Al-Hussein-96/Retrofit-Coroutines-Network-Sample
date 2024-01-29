package com.alhussain.retrofit.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.JsonNames

interface INetworkFulfilledOrder {
    val reqId: String
   val action: String
     val desc: String
     val status: String
}
package com.alhussain.retrofit.fake

import android.content.Context
import android.content.SharedPreferences
import com.alhussain.retrofit.model.ClaimRequest
import com.alhussain.retrofit.model.ClaimsRequest
import com.alhussain.retrofit.model.ConfirmOrderRequest
import com.alhussain.retrofit.model.DingOrderRequest
import com.alhussain.retrofit.model.EmposOrderRequest
import com.alhussain.retrofit.model.FulfilledDingOrderRequest
import com.alhussain.retrofit.model.INetworkOrderRequest
import com.alhussain.retrofit.model.NetworkAppUpdate
import com.alhussain.retrofit.model.NetworkOrder
import com.alhussain.retrofit.model.OrdersRequest
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FakeStore @Inject constructor(@ApplicationContext context: Context) {

    private val mSharedPref: SharedPreferences by lazy {
        context.getSharedPreferences("Axiom", Context.MODE_PRIVATE)
    }

    fun setAuthToken(token: String) {
        mSharedPref.edit().putString(AppConstants.AUTH_TOKEN, token).apply()
    }

    fun getAuthToken(): String {
        return mSharedPref.getString(AppConstants.AUTH_TOKEN, "").orEmpty()
    }

    fun setUsername(username: String) {
        mSharedPref.edit().putString(AppConstants.USERNAME, username).apply()
    }

    fun getUsername(): String = mSharedPref.getString(AppConstants.USERNAME, "19962024").orEmpty()
    fun setPassword(password: String) {
        mSharedPref.edit().putString(AppConstants.PASSWORD, password).apply()
    }

    fun getPassword(): String = mSharedPref.getString(AppConstants.PASSWORD, "lqw2ws7l").orEmpty()

    companion object {
        fun getAppUpdateRequest(): NetworkAppUpdate.NetworkAppUpdateRequest =
            NetworkAppUpdate.NetworkAppUpdateRequest(
                appid = "com.axiom.appupdater",
                ver = "1.0.1",
                deviceid = "1007"
            )

        fun getOrderRequest(): NetworkOrder.NetworkOrderRequest = NetworkOrder.NetworkOrderRequest(
            customerId = "19962024",
            cashierId = 918246313,
            deviceId = "157320",
            customerRef = "ref",
            type = "PIN",
            origin = "POS",
            items = listOf(INetworkOrderRequest.ItemRequest(productId = 1, qty = 1))
        )

        fun getConfirmOrderRequest(): ConfirmOrderRequest = ConfirmOrderRequest(
            reqId = "POS-PIN-525251-CMPSIR31AK07E5BODQ20",
            cashierId = 1482693820,
            type = "PIN",
            pinSerial = "2653140380",
            status = "printed"
        )

        fun getOrdersRequest(): OrdersRequest = OrdersRequest(
            deviceid = "785507",
            type = "ALL",
            offset = 0,
            limit = 20,
            fromdate = "2024-01-21 16:24:00 PM",
            todate = "2024-01-26 16:24:00 PM"
        )

        fun getDingLookupRequest(): DingOrderRequest = DingOrderRequest(
            type = "DING",
            accountRequest = DingOrderRequest.AccountRequest(
                number = "920000000000"
            )
        )

        fun getFulfilledDingOrderRequet(): FulfilledDingOrderRequest = FulfilledDingOrderRequest(
            cashierId = 918246313,
            customerRef = "359457090377465",
            deviceId = "785507",
            type = "DING",
            origin = "POS",
            customerId = "19962024",
            items = listOf(
                INetworkOrderRequest.ItemRequest(
                    productId = 15,
                    qty = 1,
                    amount = 1.98
                )
            ),
            dingRequest = FulfilledDingOrderRequest.DingRequest(
                accountNumber = "910000000000",
                distributorRef = "Mobile",
                sendCurrencyIso = "AED",
                skuCode = "PK_MB_TopUp_100.00",
                sendValue = 1.98,
                providerCode = "MBPK", validateOnly = "true"
            )
        )

        fun getFulfilledEmposOrderRequet(): EmposOrderRequest = EmposOrderRequest(
            cashierId = 918246313,
            customerRef = "359457090377465",
            deviceId = "785507",
            type = "DING",
            origin = "POS",
            customerId = "19962024",
            items = listOf(INetworkOrderRequest.ItemRequest(productId = 1, qty = 1, amount = 1.98)),
            accountRequest = EmposOrderRequest.AccountRequest(
                msisdn = "971500000000",
                amount = 25.0,
                subtype = ""
            )
        )

        fun getRequestClaim(): ClaimRequest = ClaimRequest(
            type = "PIN",
            pinSerial = "2307562208",
            data = "No paper",
            orderRef = 15084,
            source = "POS",
        )

        fun getClaimsRequest(): ClaimsRequest = ClaimsRequest(
            fromdate = "2022-09-05 01:00:00 AM",
            todate = "2022-10-10 11:59:59 PM"
        )
    }
}
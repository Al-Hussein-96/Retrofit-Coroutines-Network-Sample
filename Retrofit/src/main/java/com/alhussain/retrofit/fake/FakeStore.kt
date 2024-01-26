package com.alhussain.retrofit.fake

import android.content.Context
import android.content.SharedPreferences
import com.alhussain.retrofit.model.NetworkAppUpdate
import com.alhussain.retrofit.model.NetworkOrder
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
        return "123" + mSharedPref.getString(AppConstants.AUTH_TOKEN, "").orEmpty()
    }

    fun getUsername(): String = mSharedPref.getString(AppConstants.USERNAME, "525251").orEmpty()

    fun getPassword(): String = mSharedPref.getString(AppConstants.PASSWORD, "km59kjvg").orEmpty()

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
            items = listOf(NetworkOrder.NetworkOrderRequest.ItemRequest(productId = 1, qty = 1))
        )
    }
}
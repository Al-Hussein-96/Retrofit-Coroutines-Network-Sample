package com.alhussain.retrofit.fake

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FakeStore @Inject constructor(@ApplicationContext context: Context) {

    private val mSharedPref: SharedPreferences by lazy {
        context.getSharedPreferences("Axiom", Context.MODE_PRIVATE)
    }


    fun getAuthToken(): String {
        return mSharedPref.getString(AppConstants.AUTH_TOKEN, "").orEmpty()
    }

    fun getUsername(): String =  mSharedPref.getString(AppConstants.USERNAME, "525251").orEmpty()

    fun getPassword(): String =  mSharedPref.getString(AppConstants.PASSWORD, "km59kjvg").orEmpty()
}
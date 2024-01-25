package com.alhussain.retrofit.interceptors

import com.alhussain.retrofit.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

private const val APP_KEY = BuildConfig.APP_KEY


class CustomHeaderInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request();
        val newRequest = request.newBuilder().addHeader(
            "X-POSKey", APP_KEY
        ).build()
        return chain.proceed(newRequest)
    }
}
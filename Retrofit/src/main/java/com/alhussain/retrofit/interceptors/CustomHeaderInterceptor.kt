package com.alhussain.retrofit.interceptors

import com.alhussain.retrofit.BuildConfig
import com.alhussain.retrofit.fake.FakeStore
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

private const val APP_KEY = BuildConfig.APP_KEY
private const val APP_VERSION = BuildConfig.APP_VERSION


class CustomHeaderInterceptor @Inject constructor(private val fakeStore: FakeStore) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request();
        val newRequest = request.newBuilder().addHeader(
            "X-POSKey", APP_KEY
        ).addHeader("appver", APP_VERSION)



        if (fakeStore.getAuthToken().isNotEmpty()) {
            newRequest.addHeader("Authorization", "Bearer ${fakeStore.getAuthToken()}")
        }

        return chain.proceed(newRequest.build())
    }
}
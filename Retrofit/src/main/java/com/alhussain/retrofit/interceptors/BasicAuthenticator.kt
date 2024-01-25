package com.alhussain.retrofit.interceptors

import com.alhussain.retrofit.fake.FakeStore
import okhttp3.Authenticator
import okhttp3.Credentials
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route


class BasicAuthenticator(private val fakeStore: FakeStore) : Authenticator {
    override fun authenticate(route: Route?, response: Response): Request? {
        println("BasicAuthenticator")

        if (response.request.header("Authorization") != null || !response.request.url.scheme.contains("login")) {
            // If the request already had an authorization header, don't retry
            return null;
        }

        val credential: String = Credentials.basic(fakeStore.getUsername(), fakeStore.getPassword())

        return response.request.newBuilder().header("Authorization", credential).build()

    }
}
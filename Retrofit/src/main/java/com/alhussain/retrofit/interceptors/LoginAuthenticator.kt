package com.alhussain.retrofit.interceptors

import com.alhussain.retrofit.datasource.AuthDataSource
import com.alhussain.retrofit.datasource.AxiomNetworkDataSource
import com.alhussain.retrofit.fake.FakeStore
import com.alhussain.retrofit.model.ResultWrapper
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route


class LoginAuthenticator(
    private val fakeStore: FakeStore,
    private val axiomNetwork: AuthDataSource
) : Authenticator {
    override fun authenticate(route: Route?, response: Response): Request? = runBlocking {
        println("BasicAuthenticator")

        return@runBlocking if (responseCount(response) >= MAX_RETRIES) {
            null
        } else {
            val result = axiomNetwork.login()


            if (result is ResultWrapper.Success) {
                fakeStore.setAuthToken(result.value.token.accessToken)

                response.request.newBuilder()
                    .header("Authorization", "Bearer ${result.value.token.accessToken}").build()
            } else {
                null
            }
        }
    }

    private fun responseCount(response: Response): Int {
        var result = 1
        var priorResponse = response.priorResponse
        while (priorResponse != null) {
            result++
            priorResponse = priorResponse.priorResponse
        }
        return result
    }

    companion object {
        private const val MAX_RETRIES = 3
    }
}
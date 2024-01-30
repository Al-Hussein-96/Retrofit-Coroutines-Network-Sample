package com.alhussain.retrofit.interceptors

import com.alhussain.retrofit.model.NetworkFulfilledOrder
import com.alhussain.retrofit.model.ResultWrapper
import kotlinx.coroutines.delay
import kotlinx.serialization.json.Json
import okhttp3.ResponseBody
import retrofit2.Response


suspend fun <T> apiCallWithRetry(
    maxRetries: Int = 10,
    delayMillis: Long = 3000,
    apiCall: suspend () -> ResultWrapper<NetworkFulfilledOrder>
): ResultWrapper<NetworkFulfilledOrder> {
    var retryCount = 0
    var response: ResultWrapper<NetworkFulfilledOrder> = ResultWrapper.GenericError(null,null)

    do {
        // Perform the API call within a try-catch block
        try {
            response = apiCall()

            // Check if the response is successful, and return it if it is
            if (response !is ResultWrapper.Success || !response.value.shouldRetry) {
                return response
            }
            // Optionally, add more conditions to determine if retry is needed based on response status

        } catch (e: Exception) {
            // Handle exceptions if needed
        }

        // Increment the retry count and delay before the next retry
        retryCount++
        delay(delayMillis)

    } while (retryCount < maxRetries)

    // Return the last response (even if unsuccessful) after reaching the max retry count
    return response
}
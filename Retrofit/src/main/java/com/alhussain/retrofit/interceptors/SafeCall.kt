package com.alhussain.retrofit.interceptors

import com.alhussain.retrofit.model.ServerError
import com.alhussain.retrofit.model.ResultWrapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import retrofit2.HttpException
import java.io.IOException


suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher,
    apiCall: suspend () -> T
): ResultWrapper<T> {
    return withContext(dispatcher) {
        try {
            ResultWrapper.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            when (throwable) {
                is IOException -> ResultWrapper.NetworkError
                is HttpException -> {
                    val code = throwable.code()
                    val errorResponse = convertErrorBody(throwable)
                    ResultWrapper.GenericError(code, errorResponse)
                }

                else -> {
                    ResultWrapper.GenericError(null, null)
                }
            }
        }
    }
}


private fun convertErrorBody(throwable: HttpException): ServerError? {
    return try {
        Json.decodeFromString<ServerError>(throwable.response()?.errorBody()?.string().toString().orEmpty())
    } catch (exception: Exception) {
        null
    }
}
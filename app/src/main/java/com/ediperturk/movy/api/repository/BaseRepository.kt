package com.ediperturk.movy.api.repository

import com.ediperturk.movy.api.base.Result
import com.ediperturk.movy.api.data.response.BaseResponse
import com.ediperturk.movy.api.interceptor.ApiException
import com.ediperturk.movy.manager.resource.Resources

abstract class BaseRepository(
    private val resources: Resources
) {
    protected suspend fun <T : BaseResponse> makeRequest(call: suspend () -> T): Result<T> {
        return try {
            Result.Success(call.invoke())
        } catch (exception: Exception) {
            Result.Error(
                ApiException(
                    resources.getDefaultErrorTitle(),
                    exception.message ?: resources.getDefaultErrorMessage()
                )
            )
        }
    }

    protected fun <T : BaseResponse> resolve(response: Result<T>): T {
        when (response) {
            is Result.Success -> return response.data
            is Result.Error -> throw response.apiException
        }
    }
}
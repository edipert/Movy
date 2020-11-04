package com.ediperturk.movy.api.base

import com.ediperturk.movy.api.interceptor.ApiException

sealed class Result<out T : Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val apiException: ApiException) : Result<Nothing>()
}
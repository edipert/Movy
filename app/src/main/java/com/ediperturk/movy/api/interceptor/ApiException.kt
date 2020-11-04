package com.ediperturk.movy.api.interceptor

class ApiException(
    val title: String?,
    override val message: String
) : Exception()
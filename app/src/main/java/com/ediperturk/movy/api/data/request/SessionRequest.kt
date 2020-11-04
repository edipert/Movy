package com.ediperturk.movy.api.data.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SessionRequest(
    @SerialName("request_token")
    val requestToken: String
)
package com.ediperturk.movy.api.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TokenResponse(
    @SerialName("request_token") val requestToken: String,
    @SerialName("expires_at") val expiresAt: String
) : BaseResponse()
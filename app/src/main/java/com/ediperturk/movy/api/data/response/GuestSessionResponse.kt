package com.ediperturk.movy.api.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GuestSessionResponse(
    @SerialName("guest_session_id") val guestSessionId: String,
    @SerialName("expires_at") val expiresAt: String,
) : BaseResponse()
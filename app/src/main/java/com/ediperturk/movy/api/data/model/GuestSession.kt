package com.ediperturk.movy.api.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GuestSession(
    @SerialName("guest_session_id") val guestSessionId: String,
    @SerialName("expires_at") val expiresAt: String
)
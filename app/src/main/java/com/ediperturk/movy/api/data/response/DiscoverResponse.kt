package com.ediperturk.movy.api.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DiscoverResponse<T>(
    @SerialName("results") val results: List<T>
) : ListingResponse()
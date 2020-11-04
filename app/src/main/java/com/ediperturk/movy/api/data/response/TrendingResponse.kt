package com.ediperturk.movy.api.data.response

import com.ediperturk.movy.api.data.model.Media
import kotlinx.serialization.Polymorphic
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TrendingResponse<out T : Media>(
    @SerialName("results") val results: List<@Polymorphic T>
) : ListingResponse()
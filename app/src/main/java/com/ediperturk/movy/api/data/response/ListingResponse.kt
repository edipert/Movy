package com.ediperturk.movy.api.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
abstract class ListingResponse : BaseResponse() {
    @SerialName("page")
    val page: Int = -1

    @SerialName("total_results")
    val totalResults: Int = 0

    @SerialName("total_pages")
    val totalPages: Int = 0
}
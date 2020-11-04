package com.ediperturk.movy.api.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
open class BaseResponse {

    @SerialName("success")
    var success: Boolean? = false

    @SerialName("status_code")
    var statusCode: Int? = null

    @SerialName("status_message")
    var statusMessage: String? = null
}
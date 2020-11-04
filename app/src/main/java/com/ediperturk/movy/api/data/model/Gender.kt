package com.ediperturk.movy.api.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Gender {
    @SerialName("1")
    WOMAN,

    @SerialName("2")
    MAN
}
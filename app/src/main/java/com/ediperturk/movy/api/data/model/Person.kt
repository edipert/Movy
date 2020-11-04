package com.ediperturk.movy.api.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable //(with = MediaTypeSerializer::class)
@SerialName("person")
data class Person(
    @SerialName("id") val id: Long,
    @SerialName("gender") val gender: Gender,
    @SerialName("adult") val adult: Boolean,
    @SerialName("known_for_department") val knownForDepartment: String,
    @SerialName("profile_path") val profilePath: String,
    @SerialName("popularity") val popularity: Double
) : Media()
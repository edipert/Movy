package com.ediperturk.movy.api.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable //(with = MediaTypeSerializer::class)
@SerialName("tv")
data class TVShow(
    @SerialName("id") val id: Long,
    @SerialName("original_name") val originalName: String,
    @SerialName("name") val name: String,
    @SerialName("poster_path") val posterPath: String? = null,
    @SerialName("overview") val overview: String,
    @SerialName("first_air_date") val firstAirDate: String,
    @SerialName("original_language") val originalLanguage: String,
    @SerialName("backdrop_path") val backdropPath: String?,
    @SerialName("popularity") val popularity: Double,
    @SerialName("vote_count") val voteCount: Int,
    @SerialName("vote_average") val voteAverage: Double,
    @SerialName("genre_ids") val genreIds: List<Int>,
    @SerialName("origin_country") val origin_country: List<String>
) : Media()
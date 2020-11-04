package com.ediperturk.movy.api.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable //(with = MediaTypeSerializer::class)
@SerialName("movie")
data class Movie(
    @SerialName("id") val id: Long,
    @SerialName("title") val title: String,
    @SerialName("poster_path") val posterPath: String? = null,
    @SerialName("overview") val overview: String,
    @SerialName("release_date") val releaseDate: String,
    @SerialName("original_title") val originalTitle: String,
    @SerialName("original_language") val originalLanguage: String,
    @SerialName("backdrop_path") val backdropPath: String? = null,
    @SerialName("popularity") val popularity: Double,
    @SerialName("vote_count") val voteCount: Int,
    @SerialName("video") val video: Boolean,
    @SerialName("adult") val adult: Boolean,
    @SerialName("vote_average") val voteAverage: Double,
    @SerialName("genre_ids") val genreIds: List<Int>
) : Media()
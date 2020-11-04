package com.ediperturk.movy.api.repository.trending

import com.ediperturk.movy.api.data.model.Media
import com.ediperturk.movy.api.data.model.Movie
import com.ediperturk.movy.api.data.model.Person
import com.ediperturk.movy.api.data.model.TVShow
import kotlinx.coroutines.flow.Flow

interface TrendingRepository {

    suspend fun trendingAll(timeWindow: String): Flow<List<Media>>

    suspend fun trendingMovie(timeWindow: String): Flow<List<Movie>>

    suspend fun trendingTV(timeWindow: String): Flow<List<TVShow>>

    suspend fun trendingPerson(timeWindow: String): Flow<List<Person>>
}
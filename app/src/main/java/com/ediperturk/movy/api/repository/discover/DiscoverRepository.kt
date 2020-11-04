package com.ediperturk.movy.api.repository.discover

import com.ediperturk.movy.api.data.model.Movie
import com.ediperturk.movy.api.data.model.TVShow
import kotlinx.coroutines.flow.Flow

interface DiscoverRepository {

    suspend fun discoverMovie(): Flow<List<Movie>>

    suspend fun discoverTV(): Flow<List<TVShow>>
}
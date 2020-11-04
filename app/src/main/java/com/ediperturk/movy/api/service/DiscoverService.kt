package com.ediperturk.movy.api.service

import com.ediperturk.movy.api.data.model.Movie
import com.ediperturk.movy.api.data.model.TVShow
import com.ediperturk.movy.api.data.response.DiscoverResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface DiscoverService {

    @GET("discover/movie")
    suspend fun discoverMovie(@Query("api_key") apiKey: String): DiscoverResponse<Movie>

    @GET("discover/tv")
    suspend fun discoverTV(@Query("api_key") apiKey: String): DiscoverResponse<TVShow>
}
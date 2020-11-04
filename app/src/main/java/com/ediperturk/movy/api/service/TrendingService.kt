package com.ediperturk.movy.api.service

import com.ediperturk.movy.api.data.model.Media
import com.ediperturk.movy.api.data.model.Movie
import com.ediperturk.movy.api.data.model.Person
import com.ediperturk.movy.api.data.model.TVShow
import com.ediperturk.movy.api.data.response.TrendingResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TrendingService {

    @GET("trending/all/{time_window}")
    suspend fun trendingAll(
        @Path("time_window") timeWindow: String,
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): TrendingResponse<Media>

    @GET("trending/movie/{time_window}")
    suspend fun trendingMovie(
        @Path("time_window") timeWindow: String,
        @Query("api_key") apiKey: String
    ): TrendingResponse<Movie>

    @GET("trending/tv/{time_window}")
    suspend fun trendingTV(
        @Path("time_window") timeWindow: String,
        @Query("api_key") apiKey: String
    ): TrendingResponse<TVShow>

    @GET("trending/person/{time_window}")
    suspend fun trendingPerson(
        @Path("time_window") timeWindow: String,
        @Query("api_key") apiKey: String
    ): TrendingResponse<Person>
}
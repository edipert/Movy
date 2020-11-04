package com.ediperturk.movy.api.service

import com.ediperturk.movy.api.data.response.GuestSessionResponse
import com.ediperturk.movy.api.data.request.SessionRequest
import com.ediperturk.movy.api.data.response.SessionResponse
import com.ediperturk.movy.api.data.response.TokenResponse
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthService {

    @GET("authentication/token/new")
    suspend fun token(@Query("api_key") apiKey: String): TokenResponse

    @POST("authentication/guest_session/new")
    suspend fun guestSession(@Query("api_key") apiKey: String): GuestSessionResponse

    @GET("authentication/session/new")
    suspend fun session(
        @Query("api_key") apiKey: String,
        sessionRequest: SessionRequest
    ): SessionResponse
}
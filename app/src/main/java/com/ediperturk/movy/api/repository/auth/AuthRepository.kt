package com.ediperturk.movy.api.repository.auth

import com.ediperturk.movy.api.data.request.SessionRequest
import com.ediperturk.movy.api.data.response.GuestSessionResponse
import com.ediperturk.movy.api.data.response.SessionResponse
import com.ediperturk.movy.api.data.response.TokenResponse
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    suspend fun token(): Flow<TokenResponse>

    suspend fun session(sessionRequest: SessionRequest): Flow<SessionResponse>

    suspend fun guestSession(): Flow<GuestSessionResponse>
}
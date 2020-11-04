package com.ediperturk.movy.api.repository.auth

import com.ediperturk.movy.api.data.request.SessionRequest
import com.ediperturk.movy.api.repository.BaseRepository
import com.ediperturk.movy.api.service.AuthService
import com.ediperturk.movy.manager.resource.Resources
import com.ediperturk.movy.manager.session.SessionManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    resources: Resources,
    private val authService: AuthService,
    private val sessionManager: SessionManager
) : BaseRepository(resources), AuthRepository {

    override suspend fun token() = flow {
        val response = makeRequest {
            authService.token(sessionManager.getApiKey())
        }

        emit(resolve(response))
    }.flowOn(Dispatchers.IO)

    override suspend fun session(sessionRequest: SessionRequest) = flow {
        val response = makeRequest {
            authService.session(
                apiKey = sessionManager.getApiKey(),
                sessionRequest = sessionRequest
            )
        }

        emit(resolve(response))
    }.flowOn(Dispatchers.IO)

    override suspend fun guestSession() = flow {
        val response = makeRequest {
            authService.guestSession(sessionManager.getApiKey())
        }

        emit(resolve(response))
    }.flowOn(Dispatchers.IO)
}
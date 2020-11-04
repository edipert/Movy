package com.ediperturk.movy.api.repository.trending

import com.ediperturk.movy.api.repository.BaseRepository
import com.ediperturk.movy.api.service.TrendingService
import com.ediperturk.movy.manager.resource.Resources
import com.ediperturk.movy.manager.session.SessionManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class TrendingRepositoryImpl @Inject constructor(
    resources: Resources,
    private val trendingService: TrendingService,
    private val sessionManager: SessionManager
) : BaseRepository(resources), TrendingRepository {

    override suspend fun trendingAll(timeWindow: String) = flow {
        val response = makeRequest {
            trendingService.trendingAll(timeWindow, sessionManager.getApiKey(), 2)
        }

        emit(resolve(response).results)
    }.flowOn(Dispatchers.IO)

    override suspend fun trendingMovie(timeWindow: String) = flow {
        val response = makeRequest {
            trendingService.trendingMovie(timeWindow, sessionManager.getApiKey())
        }

        emit(resolve(response).results)
    }.flowOn(Dispatchers.IO)

    override suspend fun trendingTV(timeWindow: String) = flow {
        val response = makeRequest {
            trendingService.trendingTV(timeWindow, sessionManager.getApiKey())
        }

        emit(resolve(response).results)

    }.flowOn(Dispatchers.IO)

    override suspend fun trendingPerson(timeWindow: String) = flow {
        val response = makeRequest {
            trendingService.trendingPerson(timeWindow, sessionManager.getApiKey())
        }

        emit(resolve(response).results)
    }.flowOn(Dispatchers.IO)
}
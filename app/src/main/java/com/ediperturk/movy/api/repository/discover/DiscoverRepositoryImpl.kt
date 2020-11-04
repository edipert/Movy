package com.ediperturk.movy.api.repository.discover

import com.ediperturk.movy.api.repository.BaseRepository
import com.ediperturk.movy.api.service.DiscoverService
import com.ediperturk.movy.manager.resource.Resources
import com.ediperturk.movy.manager.session.SessionManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DiscoverRepositoryImpl @Inject constructor(
    resources: Resources,
    private val discoverService: DiscoverService,
    private val sessionManager: SessionManager
) : BaseRepository(resources), DiscoverRepository {

    override suspend fun discoverMovie() = flow {
        val response = makeRequest {
            discoverService.discoverMovie(sessionManager.getApiKey())
        }

        emit(resolve(response).results)
    }.flowOn(Dispatchers.IO)

    override suspend fun discoverTV() = flow {
        val response = makeRequest {
            discoverService.discoverTV(sessionManager.getApiKey())
        }

        emit(resolve(response).results)
    }.flowOn(Dispatchers.IO)
}
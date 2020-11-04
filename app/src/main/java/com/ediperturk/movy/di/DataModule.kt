package com.ediperturk.movy.di

import com.ediperturk.movy.api.repository.auth.AuthRepository
import com.ediperturk.movy.api.repository.auth.AuthRepositoryImpl
import com.ediperturk.movy.api.repository.discover.DiscoverRepository
import com.ediperturk.movy.api.repository.discover.DiscoverRepositoryImpl
import com.ediperturk.movy.api.repository.trending.TrendingRepository
import com.ediperturk.movy.api.repository.trending.TrendingRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun bindAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository

    @Binds
    @Singleton
    abstract fun bindDiscoverRepository(discoverRepositoryImpl: DiscoverRepositoryImpl): DiscoverRepository

    @Binds
    @Singleton
    abstract fun bindTredndingRepository(trendingRepositoryImpl: TrendingRepositoryImpl): TrendingRepository
}
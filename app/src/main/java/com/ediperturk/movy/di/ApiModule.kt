package com.ediperturk.movy.di

import com.ediperturk.movy.BuildConfig
import com.ediperturk.movy.api.data.model.Media
import com.ediperturk.movy.api.data.model.Movie
import com.ediperturk.movy.api.data.model.Person
import com.ediperturk.movy.api.data.model.TVShow
import com.ediperturk.movy.api.interceptor.ConnectionInterceptor
import com.ediperturk.movy.api.service.AuthService
import com.ediperturk.movy.api.service.DiscoverService
import com.ediperturk.movy.api.service.TrendingService
import com.ediperturk.movy.manager.connection.Connectivity
import com.ediperturk.movy.manager.resource.Resources
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideConnectionInterceptor(
        connectivity: Connectivity,
        resources: Resources
    ): ConnectionInterceptor {
        return ConnectionInterceptor(connectivity, resources)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(connectionInterceptor: ConnectionInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(connectionInterceptor)
            .build()
    }

    @ExperimentalSerializationApi
    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        val contentType = "application/json".toMediaType()

        val polymorphicSerializersModule = SerializersModule {
            polymorphic(Media::class) {
                subclass(Movie::class, Movie.serializer())
                subclass(TVShow::class, TVShow.serializer())
                subclass(Person::class, Person.serializer())
            }
        }

        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(Json {
                ignoreUnknownKeys = true
                encodeDefaults = false
                coerceInputValues = true
                serializersModule = polymorphicSerializersModule
                classDiscriminator = "media_type"
            }.asConverterFactory(contentType))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideAuthService(retrofit: Retrofit): AuthService {
        return retrofit.create(AuthService::class.java)
    }

    @Provides
    @Singleton
    fun provideDiscoverService(retrofit: Retrofit): DiscoverService {
        return retrofit.create(DiscoverService::class.java)
    }

    @Provides
    @Singleton
    fun provideTrendingService(retrofit: Retrofit): TrendingService {
        return retrofit.create(TrendingService::class.java)
    }
}
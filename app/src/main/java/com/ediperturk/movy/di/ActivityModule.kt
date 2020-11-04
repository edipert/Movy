package com.ediperturk.movy.di

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {

    @Provides
    @ActivityScoped
    fun provideActivityContext(activity: Activity): Context {
        return activity
    }

    @Provides
    @ActivityScoped
    fun provideFragmentManager(activity: AppCompatActivity): FragmentManager {
        return activity.supportFragmentManager
    }
}
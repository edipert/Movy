package com.ediperturk.movy.di

import android.app.Activity
import androidx.navigation.NavController
import com.ediperturk.movy.common.extension.findNavController
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
    fun provideNavController(activity: Activity): NavController {
        return activity.findNavController()
    }
}
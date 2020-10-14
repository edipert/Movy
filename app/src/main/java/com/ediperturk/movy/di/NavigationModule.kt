package com.ediperturk.movy.di

import com.ediperturk.movy.ui.main.navigation.MainNavigator
import com.ediperturk.movy.ui.main.navigation.MainNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
abstract class NavigationModule {

    @Binds
    @ActivityScoped
    abstract fun provideMainNavigtor(mainNavigatorImpl: MainNavigatorImpl): MainNavigator
}
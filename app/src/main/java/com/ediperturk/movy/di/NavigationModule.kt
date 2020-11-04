package com.ediperturk.movy.di

import android.app.Activity
import androidx.navigation.NavController
import com.ediperturk.movy.common.extension.findNavController
import com.ediperturk.movy.ui.detail.navigation.DetailNavigator
import com.ediperturk.movy.ui.detail.navigation.DetailNavigatorImpl
import com.ediperturk.movy.ui.main.navigation.MainNavigator
import com.ediperturk.movy.ui.main.navigation.MainNavigatorImpl
import com.ediperturk.movy.ui.signin.navigation.SignInNavigator
import com.ediperturk.movy.ui.signin.navigation.SignInNavigatorImpl
import com.ediperturk.movy.ui.signup.navigation.SignUpNavigator
import com.ediperturk.movy.ui.signup.navigation.SignUpNavigatorImpl
import com.ediperturk.movy.ui.splash.navigation.SplashNavigator
import com.ediperturk.movy.ui.splash.navigation.SplashNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
abstract class NavigationModule {

    companion object {
        @Provides
        @ActivityScoped
        fun provideNavController(activity: Activity): NavController {
            return activity.findNavController()
        }
    }

    @Binds
    @ActivityScoped
    abstract fun bindMainNavigator(mainNavigatorImpl: MainNavigatorImpl): MainNavigator

    @Binds
    @ActivityScoped
    abstract fun bindSplashNavigator(splashNavigatorImpl: SplashNavigatorImpl): SplashNavigator

    @Binds
    @ActivityScoped
    abstract fun bindSignInNavigator(signInNavigatorImpl: SignInNavigatorImpl): SignInNavigator

    @Binds
    @ActivityScoped
    abstract fun bindSignUpNavigator(signUpNavigatorImpl: SignUpNavigatorImpl): SignUpNavigator

    @Binds
    @ActivityScoped
    abstract fun bindDetailNavigator(detailNavigatorImpl: DetailNavigatorImpl): DetailNavigator
}
package com.ediperturk.movy.ui.splash.navigation

import androidx.navigation.NavController
import com.ediperturk.movy.ui.base.navigation.NavigatorImpl
import com.ediperturk.movy.ui.splash.SplashFragmentDirections
import javax.inject.Inject

class SplashNavigatorImpl @Inject constructor(
    private val navController: NavController
) : NavigatorImpl(navController), SplashNavigator {

    override fun toMain() {
        navController.navigate(
            SplashFragmentDirections.actionSplashFragmentToMainFragment()
        )
    }

    override fun toSignIn() {
        navController.navigate(
            SplashFragmentDirections.actionSplashFragmentToSignInFragment()
        )
    }
}
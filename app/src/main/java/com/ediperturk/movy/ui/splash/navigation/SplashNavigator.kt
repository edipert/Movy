package com.ediperturk.movy.ui.splash.navigation

import com.ediperturk.movy.ui.base.navigation.Navigator

interface SplashNavigator : Navigator {

    fun toMain()

    fun toSignIn()
}
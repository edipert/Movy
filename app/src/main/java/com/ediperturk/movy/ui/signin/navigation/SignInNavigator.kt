package com.ediperturk.movy.ui.signin.navigation

import com.ediperturk.movy.ui.base.navigation.Navigator

interface SignInNavigator : Navigator {

    fun toMain()

    fun toSignUp()
}
package com.ediperturk.movy.ui.signup.navigation

import androidx.navigation.NavController
import com.ediperturk.movy.ui.base.navigation.NavigatorImpl
import com.ediperturk.movy.ui.signup.SignUpFragmentDirections
import javax.inject.Inject

class SignUpNavigatorImpl @Inject constructor(
    private val navController: NavController
) : NavigatorImpl(navController), SignUpNavigator {

    override fun toMain() {
        navController.navigate(
            SignUpFragmentDirections.actionSignUpFragmentToMainFragment()
        )
    }

    override fun toSignIn() {
        navController.navigate(
            SignUpFragmentDirections.actionSignUpFragmentToSignInFragment()
        )
    }
}
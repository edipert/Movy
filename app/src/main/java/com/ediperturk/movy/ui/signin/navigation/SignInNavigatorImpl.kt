package com.ediperturk.movy.ui.signin.navigation

import androidx.navigation.NavController
import com.ediperturk.movy.ui.base.navigation.NavigatorImpl
import com.ediperturk.movy.ui.signin.SignInFragmentDirections
import javax.inject.Inject

class SignInNavigatorImpl @Inject constructor(
    private val navController: NavController
) : NavigatorImpl(navController) , SignInNavigator {

    override fun toMain() {
        navController.navigate(
            SignInFragmentDirections.actionSignInFragmentToMainFragment()
        )
    }

    override fun toSignUp() {
        navController.navigate(
            SignInFragmentDirections.actionSignInFragmentToSignUpFragment()
        )
    }
}
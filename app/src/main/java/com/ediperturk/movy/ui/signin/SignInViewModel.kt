package com.ediperturk.movy.ui.signin

import androidx.hilt.lifecycle.ViewModelInject
import com.ediperturk.movy.ui.base.BaseViewModel
import com.ediperturk.movy.ui.signin.navigation.SignInNavigator

class SignInViewModel @ViewModelInject constructor(
    override val navigator: SignInNavigator
) : BaseViewModel() {

    override fun onStart() {

    }

    fun onBackClick() {
        navigator.back()
    }
}
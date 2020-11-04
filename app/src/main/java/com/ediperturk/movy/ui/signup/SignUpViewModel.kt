package com.ediperturk.movy.ui.signup

import androidx.hilt.lifecycle.ViewModelInject
import com.ediperturk.movy.ui.base.BaseViewModel
import com.ediperturk.movy.ui.signup.navigation.SignUpNavigator

class SignUpViewModel @ViewModelInject constructor(
    override val navigator: SignUpNavigator
) : BaseViewModel() {

    override fun onStart() {

    }
}
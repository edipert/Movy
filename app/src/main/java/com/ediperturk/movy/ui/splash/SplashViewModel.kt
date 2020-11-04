package com.ediperturk.movy.ui.splash

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import com.ediperturk.movy.api.repository.auth.AuthRepository
import com.ediperturk.movy.manager.resource.Resources
import com.ediperturk.movy.manager.session.SessionManager
import com.ediperturk.movy.ui.base.BaseViewModel
import com.ediperturk.movy.ui.splash.navigation.SplashNavigator
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class SplashViewModel @ViewModelInject constructor(
    override val navigator: SplashNavigator,
    private val resources: Resources,
    private val authRepository: AuthRepository,
    private val sessionManager: SessionManager
) : BaseViewModel() {

    override fun onStart() {
        viewModelScope.launch {
            authRepository.guestSession()
                .onStart {

                }.catch {
                    handleException(resources, it)
                }.collect {
                    sessionManager.saveGuestSessionId(it.guestSessionId)
                    navigator.toMain()
                }
        }
    }
}
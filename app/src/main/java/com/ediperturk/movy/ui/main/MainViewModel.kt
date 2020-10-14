package com.ediperturk.movy.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import com.ediperturk.movy.ui.base.BaseViewModel
import com.ediperturk.movy.ui.main.navigation.MainNavigator

class MainViewModel @ViewModelInject constructor(
    private val mainNavigator: MainNavigator
) : BaseViewModel() {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart(){

    }
}
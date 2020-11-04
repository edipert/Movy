package com.ediperturk.movy.ui.detail

import androidx.hilt.lifecycle.ViewModelInject
import com.ediperturk.movy.ui.base.BaseViewModel
import com.ediperturk.movy.ui.detail.navigation.DetailNavigator

class DetailViewModel @ViewModelInject constructor(
    override val navigator: DetailNavigator
) : BaseViewModel() {

    override fun onStart() {

    }
}
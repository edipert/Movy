package com.ediperturk.movy.ui.main

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import com.ediperturk.movy.api.repository.trending.TrendingRepository
import com.ediperturk.movy.manager.resource.Resources
import com.ediperturk.movy.ui.base.BaseViewModel
import com.ediperturk.movy.ui.main.navigation.MainNavigator
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class MainViewModel @ViewModelInject constructor(
    override val navigator: MainNavigator,
    private val resources: Resources,
    private val trendingRepository: TrendingRepository
) : BaseViewModel() {

    override fun onStart() {
        viewModelScope.launch {
            trendingRepository.trendingAll("day")
                .onStart {
                    //TODO start loading
                }.catch { exception ->
                    handleException(resources, exception)
                }.collect {
                    Log.i("MOVYLOG", it.toString())
                }
        }
    }
}
package com.ediperturk.movy.ui.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import com.ediperturk.movy.api.interceptor.ApiException
import com.ediperturk.movy.manager.resource.Resources
import com.ediperturk.movy.ui.base.navigation.Navigator
import kotlinx.coroutines.Job

abstract class BaseViewModel : ViewModel(), LifecycleObserver {

    protected abstract val navigator: Navigator

    private val jobList = mutableListOf<Job>()

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    open fun onStart() {

    }

    protected fun addJob(job: Job) {
        jobList.add(job)
    }

    protected fun onError(title: String?, message: String) {
        navigator.alert(title, message)
    }

    protected fun handleException(resources: Resources, throwable: Throwable) {
        when (throwable) {
            is ApiException -> onError(throwable.title, throwable.message)
            else -> onError(
                resources.getDefaultNetworkExceptionTitle(),
                throwable.message ?: resources.getDefaultNetworkExceptionMessage()
            )
        }
    }

    override fun onCleared() {
        super.onCleared()
        jobList.forEach {
            it.cancel()
        }
    }
}
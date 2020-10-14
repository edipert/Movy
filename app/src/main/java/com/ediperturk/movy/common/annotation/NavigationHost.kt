package com.ediperturk.movy.common.annotation

import androidx.annotation.IdRes

@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class NavigationHost(@IdRes val hostViewId: Int)
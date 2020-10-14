package com.ediperturk.movy.common.extension

import android.app.Activity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.ediperturk.movy.common.annotation.NavigationHost

fun Activity.findNavController(): NavController {
    val navigationHost = this.javaClass.getAnnotation(NavigationHost::class.java)
        ?: throw Exception("Activity must have navigation host!")

    return Navigation.findNavController(this, navigationHost.hostViewId)
}
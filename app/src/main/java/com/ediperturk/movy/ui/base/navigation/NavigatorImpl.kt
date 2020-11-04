package com.ediperturk.movy.ui.base.navigation

import android.util.Log
import androidx.navigation.NavController
import javax.inject.Inject

open class NavigatorImpl @Inject constructor(
    private val navController: NavController
) : Navigator {

    override fun alert(title: String?, message: String) {
        Log.i("MOVYLOG", "$title - $message")
    }

    override fun progress() {
        Log.i("MOVYLOG", "progress")
    }

    override fun dismiss() {
        back()
    }

    override fun back() {
        navController.popBackStack()
    }
}
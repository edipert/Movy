package com.ediperturk.movy.ui.detail.navigation

import androidx.navigation.NavController
import com.ediperturk.movy.ui.base.navigation.NavigatorImpl
import javax.inject.Inject

class DetailNavigatorImpl @Inject constructor(
    private val navController: NavController
) : NavigatorImpl(navController), DetailNavigator {

}
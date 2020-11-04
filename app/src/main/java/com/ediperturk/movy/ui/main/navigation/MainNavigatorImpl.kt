package com.ediperturk.movy.ui.main.navigation

import androidx.navigation.NavController
import com.ediperturk.movy.ui.base.navigation.NavigatorImpl
import javax.inject.Inject

class MainNavigatorImpl @Inject constructor(
    private val navController: NavController
) : NavigatorImpl(navController), MainNavigator {

}
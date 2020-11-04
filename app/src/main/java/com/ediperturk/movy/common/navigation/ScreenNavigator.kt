package com.ediperturk.movy.common.navigation

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavDestination
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.fragment.FragmentNavigator

@Navigator.Name("screen")
class ScreenNavigator(
    private val activity: Activity,
    private val manager: FragmentManager,
    private val containerId: Int
) : FragmentNavigator(activity, manager, containerId) {

    override fun navigate(
        destination: Destination,
        args: Bundle?,
        navOptions: NavOptions?,
        navigatorExtras: Navigator.Extras?
    ): NavDestination? {
        val tag = destination.id.toString()
        val transaction = manager.beginTransaction()

        val initialNavigate = manager.fragments.isEmpty()
        val className = destination.className
        val fragment = manager.fragmentFactory.instantiate(activity.classLoader, className)

        if (initialNavigate || navOptions?.shouldLaunchSingleTop() == true) {
            transaction.replace(containerId, fragment, tag)
            transaction.setPrimaryNavigationFragment(fragment)
        } else {
            transaction.add(containerId, fragment, tag)
            transaction.addToBackStack(tag)
        }

        fragment.arguments = args
        transaction.commit()

        return destination
    }

    override fun popBackStack(): Boolean {
        return if (manager.primaryNavigationFragment != manager.fragments.last()) {
            manager.popBackStack()
            true
        } else {
            activity.finish()
            false
        }
    }
}
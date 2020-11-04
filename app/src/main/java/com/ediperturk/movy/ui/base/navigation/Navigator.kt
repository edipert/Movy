package com.ediperturk.movy.ui.base.navigation

interface Navigator {

    fun alert(title: String?, message: String)

    fun progress()

    fun dismiss()

    fun back()
}
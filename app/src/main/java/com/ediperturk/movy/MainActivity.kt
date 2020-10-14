package com.ediperturk.movy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ediperturk.movy.common.annotation.NavigationHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@NavigationHost(R.id.nav_host_fragment)
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }
}
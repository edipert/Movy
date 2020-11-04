package com.ediperturk.movy.ui.splash

import androidx.fragment.app.viewModels
import com.ediperturk.movy.R
import com.ediperturk.movy.databinding.SplashFragmentBinding
import com.ediperturk.movy.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment<SplashViewModel, SplashFragmentBinding>() {

    override val viewModel: SplashViewModel by viewModels()

    override fun getLayoutId() = R.layout.splash_fragment

    override fun initUserInterface() {

    }

}
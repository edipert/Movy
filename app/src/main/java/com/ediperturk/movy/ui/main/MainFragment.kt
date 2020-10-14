package com.ediperturk.movy.ui.main

import androidx.fragment.app.viewModels
import com.ediperturk.movy.R
import com.ediperturk.movy.databinding.MainFragmentBinding
import com.ediperturk.movy.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<MainViewModel, MainFragmentBinding>() {

    override val viewModel: MainViewModel by viewModels()

    override fun getLayoutId() = R.layout.main_fragment

    override fun initUserInterface() {

    }
}
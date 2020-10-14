package com.ediperturk.movy.ui.detail

import androidx.fragment.app.viewModels
import com.ediperturk.movy.R
import com.ediperturk.movy.databinding.DetailFragmentBinding
import com.ediperturk.movy.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<DetailViewModel, DetailFragmentBinding>() {

    override val viewModel: DetailViewModel by viewModels()

    override fun getLayoutId() = R.layout.detail_fragment

    override fun initUserInterface() {

    }
}
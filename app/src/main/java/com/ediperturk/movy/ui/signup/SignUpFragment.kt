package com.ediperturk.movy.ui.signup

import androidx.fragment.app.viewModels
import com.ediperturk.movy.R
import com.ediperturk.movy.databinding.SignUpFragmentBinding
import com.ediperturk.movy.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment : BaseFragment<SignUpViewModel, SignUpFragmentBinding>() {

    override val viewModel: SignUpViewModel by viewModels()

    override fun getLayoutId() = R.layout.sign_up_fragment

    override fun initUserInterface() {

    }
}
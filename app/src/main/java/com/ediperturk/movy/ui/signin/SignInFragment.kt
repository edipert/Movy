package com.ediperturk.movy.ui.signin

import androidx.fragment.app.viewModels
import com.ediperturk.movy.R
import com.ediperturk.movy.databinding.SignInFragmentBinding
import com.ediperturk.movy.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInFragment : BaseFragment<SignInViewModel, SignInFragmentBinding>() {
    override val viewModel: SignInViewModel by viewModels()

    override fun getLayoutId() = R.layout.sign_in_fragment

    override fun initUserInterface() {

    }
}
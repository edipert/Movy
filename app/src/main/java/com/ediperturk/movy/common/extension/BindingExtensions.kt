package com.ediperturk.movy.common.extension

import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("backgroundDrawable")
fun setTextInputLayoutBackground(
    textInputLayout: TextInputLayout,
    @DrawableRes drawable: Int
) {
    textInputLayout.setBackgroundResource(drawable)
}
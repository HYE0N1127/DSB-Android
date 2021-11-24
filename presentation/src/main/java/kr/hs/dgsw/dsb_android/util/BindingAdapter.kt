package kr.hs.dgsw.dsb_android.util

import android.view.View
import androidx.databinding.BindingAdapter

object BindingAdapter {
    @JvmStatic
    @BindingAdapter("isSelected")
    fun setSelected(view: View, selected: Boolean) {
        view.isSelected = selected
    }
}
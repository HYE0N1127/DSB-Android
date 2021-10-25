package kr.hs.dgsw.dsb_android.base

import androidx.lifecycle.ViewModel
import java.lang.ref.WeakReference

open class BaseItemViewModel<N>: ViewModel() {

    private var _navigator: WeakReference<N>? = null

    val navigator : WeakReference<N>?
        get() = _navigator

    fun setNavigator(navigator: N) {
        _navigator = WeakReference(navigator)
    }

    override fun onCleared() {
        super.onCleared()
        navigator?.clear()
    }
}
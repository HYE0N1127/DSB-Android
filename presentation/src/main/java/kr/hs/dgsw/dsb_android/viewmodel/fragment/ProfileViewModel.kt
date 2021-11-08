package kr.hs.dgsw.dsb_android.viewmodel.fragment

import android.view.View
import kr.hs.dgsw.dsb_android.base.BaseViewModel
import kr.hs.dgsw.dsb_android.util.SingleLiveEvent

class ProfileViewModel : BaseViewModel() {
    val onClickPrivacyPolicyEvent = SingleLiveEvent<Unit>()
    val onClickAccountListEvent = SingleLiveEvent<Unit>()
    val onClickLogoutEvent = SingleLiveEvent<Unit>()

    fun onClickLogout(view: View) {
        onClickLogoutEvent.call()
    }

    fun onClickPrivacyPolicy(view: View) {
        onClickPrivacyPolicyEvent.call()
    }

    fun onClickAccountList(view: View) {
        onClickAccountListEvent.call()
    }
}
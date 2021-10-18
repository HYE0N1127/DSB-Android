package kr.hs.dgsw.dsb_android.viewmodel

import androidx.lifecycle.MutableLiveData
import kr.hs.dgsw.dsb_android.base.BaseViewModel
import kr.hs.dgsw.dsb_android.util.SingleLiveEvent

class RegisterViewModel : BaseViewModel() {
    val id = MutableLiveData<String>()
    val pw = MutableLiveData<String>()
    val name = MutableLiveData<String>()
    val nickName = MutableLiveData<String>()
    val email = MutableLiveData<String>()

    val emptyEvent = MutableLiveData(true)
    val registerEvent = SingleLiveEvent<Unit>()

    val isAgree = MutableLiveData(false)

    fun onClickAgree() {
        isAgree.value = isAgree.value != true
    }

    fun onClickRegister() {
        registerEvent.call()
    }
}
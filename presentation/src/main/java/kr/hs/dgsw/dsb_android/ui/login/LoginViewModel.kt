package kr.hs.dgsw.dsb_android.ui.login

import android.widget.EditText
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.hs.dgsw.dsb_android.base.BaseViewModel
import kr.hs.dgsw.dsb_android.util.SingleLiveEvent

class LoginViewModel : BaseViewModel() {
    val onRegisterClickEvent = SingleLiveEvent<Unit>()
    val onLoginClickEvent = SingleLiveEvent<Unit>()

    val id = MutableLiveData<EditText>()
    val pw = MutableLiveData<EditText>()

    fun onClickRegister() {
        onRegisterClickEvent.call()
    }

    fun onClickLogin() {
        onLoginClickEvent.call()
    }
}
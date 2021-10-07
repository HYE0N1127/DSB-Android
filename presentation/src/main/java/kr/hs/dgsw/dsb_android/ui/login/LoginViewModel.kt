package kr.hs.dgsw.dsb_android.ui.login

import android.widget.EditText
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.hs.dgsw.dsb_android.util.SingleLiveEvent

class LoginViewModel : ViewModel() {
    val onRegisterClickEvent = SingleLiveEvent<Unit>()
    val id = MutableLiveData<EditText>()
    val pw = MutableLiveData<EditText>()

    fun onClickRegister() {
        onRegisterClickEvent.call()
    }
}
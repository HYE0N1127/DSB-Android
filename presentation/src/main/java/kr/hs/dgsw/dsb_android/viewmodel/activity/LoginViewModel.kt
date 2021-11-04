package kr.hs.dgsw.dsb_android.viewmodel.activity

import android.view.View
import androidx.lifecycle.MutableLiveData
import io.reactivex.observers.DisposableCompletableObserver
import kr.hs.dgsw.domain.repository.AuthRepository
import kr.hs.dgsw.dsb_android.base.BaseViewModel
import kr.hs.dgsw.dsb_android.util.SingleLiveEvent

class LoginViewModel () : BaseViewModel() {

    val onRegisterClickEvent = SingleLiveEvent<Unit>()

    val loginSuccessEvent = SingleLiveEvent<Unit>()

    val id = MutableLiveData<String>()
    val pw = MutableLiveData<String>()

    fun login(view: View?) {
        loginSuccessEvent.call()
    }


    fun onClickRegister() {
        onRegisterClickEvent.call()
    }
}
package kr.hs.dgsw.dsb_android.viewmodel

import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.observers.DisposableCompletableObserver
import kr.hs.dgsw.domain.repository.AuthRepository
import kr.hs.dgsw.dsb_android.base.BaseViewModel
import kr.hs.dgsw.dsb_android.util.SingleLiveEvent
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : BaseViewModel() {

    val onRegisterClickEvent = SingleLiveEvent<Unit>()
//    val onLoginClickEvent = SingleLiveEvent<Unit>()

    val loginSuccessEvent = SingleLiveEvent<Unit>()

    val id = MutableLiveData<String>()
    val pw = MutableLiveData<String>()

    fun login(view: View?) {
        if (id.value.isNullOrBlank() || pw.value.isNullOrBlank()) {
            onErrorEvent.value = Throwable("아이디 또는 패스워드를 입력해주세요.")
        } else {
            isLoading.value = true
            addDisposable(authRepository.login(id.value!!, pw.value!!),
                object : DisposableCompletableObserver() {
                    override fun onComplete() {
                        loginSuccessEvent.call()
                        isLoading.value = false
                    }

                    override fun onError(e: Throwable) {
                        onErrorEvent.value = e
                        isLoading.value = false
                    }
                })
        }
    }


    fun onClickRegister() {
        onRegisterClickEvent.call()
    }
}
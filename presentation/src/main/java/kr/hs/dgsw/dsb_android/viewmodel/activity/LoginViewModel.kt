package kr.hs.dgsw.dsb_android.viewmodel.activity

import android.view.View
import androidx.lifecycle.MutableLiveData
import io.reactivex.observers.DisposableCompletableObserver
import kr.hs.dgsw.domain.usecase.auth.LoginUseCase
import kr.hs.dgsw.dsb_android.base.BaseViewModel
import kr.hs.dgsw.dsb_android.util.SingleLiveEvent

class LoginViewModel(private val loginUseCase: LoginUseCase) : BaseViewModel() {

    val onRegisterClickEvent = SingleLiveEvent<Unit>()

    val inputEmptyEvent = SingleLiveEvent<Unit>()
    val loginSuccessEvent = SingleLiveEvent<Unit>()

    val id = MutableLiveData<String>()
    val pw = MutableLiveData<String>()

    fun login(view: View?) {
        if (id.value.isNullOrBlank() || pw.value.isNullOrBlank()) {
            inputEmptyEvent.call()
        } else {
            addDisposable(loginUseCase.buildUseCaseObservable(LoginUseCase.Params(id.value!!, pw.value!!)),
                object : DisposableCompletableObserver() {
                    override fun onComplete() {
                        loginSuccessEvent.call()
                    }

                    override fun onError(e: Throwable) {
                        onErrorEvent.value = e
                    }

                })
        }
    }


    fun onClickRegister() {
        onRegisterClickEvent.call()
    }
}
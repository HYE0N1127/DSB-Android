package kr.hs.dgsw.dsb_android.viewmodel.activity

import android.view.View
import androidx.lifecycle.MutableLiveData
import io.reactivex.observers.DisposableCompletableObserver
import kr.hs.dgsw.domain.request.auth.IdDoubleValidRequest
import kr.hs.dgsw.domain.usecase.auth.IdDoubleValidUseCase
import kr.hs.dgsw.dsb_android.base.BaseViewModel
import kr.hs.dgsw.dsb_android.util.SingleLiveEvent

class RegisterViewModel(
    private val idDoubleValidUseCase: IdDoubleValidUseCase,
) : BaseViewModel() {

    val id = MutableLiveData<String>()
    val pw = MutableLiveData<String>()
    val name = MutableLiveData<String>()
    val personalNumber = MutableLiveData<String>()
    val nickName = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val phoneNumber = MutableLiveData<String>()

    val idDoubleValidEvent = MutableLiveData(false)
    val emptyEvent = MutableLiveData(true)
    val registerEvent = SingleLiveEvent<Unit>()
    val picProfileImageEvent = SingleLiveEvent<Unit>()

    val isAgree = MutableLiveData(false)

    fun onClickAgree() {
        isAgree.value = isAgree.value != true
    }

    fun onClickRegister() {
        registerEvent.call()
    }

    fun onClickProfileImage() {
        picProfileImageEvent.call()
    }

    fun onClickIdAvailable(view: View) {
        addDisposable(idDoubleValidUseCase.buildUseCaseObservable(IdDoubleValidUseCase.Params(id.value!!)),
            object : DisposableCompletableObserver() {
                override fun onComplete() {
                    idDoubleValidEvent.value = true
                }

                override fun onError(e: Throwable) {
                    idDoubleValidEvent.value = false
                }

            })
    }
}
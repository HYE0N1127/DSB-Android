package kr.hs.dgsw.dsb_android.viewmodel.activity

import android.view.View
import androidx.lifecycle.MutableLiveData
import io.reactivex.observers.DisposableCompletableObserver
import kr.hs.dgsw.domain.request.auth.IdDoubleValidRequest
import kr.hs.dgsw.domain.usecase.auth.IdDoubleValidUseCase
import kr.hs.dgsw.domain.usecase.auth.RegisterUseCase
import kr.hs.dgsw.dsb_android.base.BaseViewModel
import kr.hs.dgsw.dsb_android.util.SingleLiveEvent

class RegisterViewModel(
    private val idDoubleValidUseCase: IdDoubleValidUseCase,
    private val registerUseCase: RegisterUseCase,
) : BaseViewModel() {

    val id = MutableLiveData<String>()
    val pw = MutableLiveData<String>()
    val name = MutableLiveData<String>()
    val profileImage = MutableLiveData<String>()
    val nickName = MutableLiveData<String>()
    val birth = MutableLiveData<String>()
    val phoneNumber = MutableLiveData<String>()

    val registerSuccessEvent = SingleLiveEvent<Unit>()
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

    fun idAvailable() {
        addDisposable(idDoubleValidUseCase.buildUseCaseObservable(IdDoubleValidUseCase.Params(id.value!!)),
            object : DisposableCompletableObserver() {
                override fun onComplete() {
                    idDoubleValidEvent.value = true
                }

                override fun onError(e: Throwable) {
                    onErrorEvent.value = e
                }

            })
    }

    fun register(view: View?) {
        addDisposable(registerUseCase.buildUseCaseObservable(RegisterUseCase.Params(
            id.value!!,
            pw.value!!,
            name.value!!,
            nickName.value!!,
            phoneNumber.value!!,
            birth.value!!,
            profileImage.value!!
        )),
            object : DisposableCompletableObserver() {
                override fun onComplete() {
                    registerSuccessEvent.call()
                }

                override fun onError(e: Throwable) {
                    onErrorEvent.value = e
                }

            })
    }

}
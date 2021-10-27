package kr.hs.dgsw.dsb_android.viewmodel.item

import androidx.lifecycle.MutableLiveData
import kr.hs.dgsw.domain.entity.Account
import kr.hs.dgsw.dsb_android.base.BaseViewModel
import kr.hs.dgsw.dsb_android.util.SingleLiveEvent

class RemittanceAccountItemViewModel : BaseViewModel() {
    private lateinit var account: Account
    val onClickAccountEvent = SingleLiveEvent<Int>()

    val name = MutableLiveData<String>()
    val accountNumber = MutableLiveData<String>()
    val accountProfileImage = MutableLiveData<String>()

    fun bind(account: Account) {
        this.account = account
    }

    fun onClickAccount() {
        onClickAccountEvent.value = account.idx
    }


}
package kr.hs.dgsw.dsb_android.viewmodel.item

import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide
import kr.hs.dgsw.domain.entity.Account
import kr.hs.dgsw.dsb_android.base.BaseItemViewModel
import kr.hs.dgsw.dsb_android.navigator.AccountNavigator
import kr.hs.dgsw.dsb_android.util.SingleLiveEvent

class AccountItemViewModel : BaseItemViewModel<AccountNavigator>() {
    val onRemittanceEvent = SingleLiveEvent<Int>()

    val accountName = MutableLiveData<String>()
    val balance = MutableLiveData<Int>()
    val accountProfileImage = MutableLiveData<String>()

    fun bind(account: Account) {
        accountName.value = account.accountName
        balance.value = account.balance
        accountProfileImage.value = account.accountProfileImage
    }

    fun onClickRemittance() {

    }

}
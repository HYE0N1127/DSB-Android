package kr.hs.dgsw.data.datasource

import kr.hs.dgsw.data.base.BaseDataSource
import kr.hs.dgsw.data.network.remote.AccountRemote

class AccountDataSource(override val remote: AccountRemote, override val cache: Any) :
    BaseDataSource<AccountRemote, Any>() {

    fun getAllAccount() = remote.getAllAccount()

    fun getAccountOtherBank() = remote.getAccountOtherBank()

    fun getMyAccountByToken() = remote.getMyAccountByToken()

    fun getPassword(accountNum : String, accountPw : String) = remote.getPassword(accountNum, accountPw)

    fun getAccountByAccountNumber(accountNum: String) = remote.getAccountByAccountNumber(accountNum)
}
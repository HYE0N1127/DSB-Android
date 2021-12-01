package kr.hs.dgsw.data.network.remote

import kr.hs.dgsw.data.base.BaseRemote
import kr.hs.dgsw.data.network.service.AccountService
import retrofit2.http.Path

class AccountRemote(override val service: AccountService) : BaseRemote<AccountService>() {

    fun getAllAccount() = service.getAllAccount().map(getResponseData())

    fun getAccountOtherBank() = service.getAccountOtherBank().map(getResponseData())

    fun getMyAccountByToken() = service.getMyAccountByToken().map(getResponseData())

    fun getPassword(accountNum: String, accountPw: String) = service.getPassword(accountNum, accountPw).map(getResponseMessage())

    fun getAccountByAccountNumber(accountNum : String) = service.getAccountByAccountNumber(accountNum).map(getResponseData())
}
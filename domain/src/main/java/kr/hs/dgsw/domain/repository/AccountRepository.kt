package kr.hs.dgsw.domain.repository

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.domain.entity.Account

interface AccountRepository {

    fun getAllAccount(): Single<List<Account>>

    fun getOtherAccount(): Single<List<Account>>

    fun getAccountByPhoneNumber(phone: String): Single<List<Account>>

    fun getAccountByAccountNumber(accountNum: String): Single<List<Account>>

    fun findAccountNumber(accountNum: String): Single<List<String>>

    fun getAllAsset(): Single<Int>

    fun getAllAssetOtherAsset(): Single<Int>

    fun postAccount(name: String, password: String): Single<String>

    fun addAccount(
        accountNum: String,
        name: String,
        password: String,
        pay: Int): Single<String>

    fun moveAssetMyAccount(
        sendAccountNum: String,
        receiveAccountNum: String,
        receiveAccountPw: String,
        transactionPay: Int,
    ) : Single<String>
}
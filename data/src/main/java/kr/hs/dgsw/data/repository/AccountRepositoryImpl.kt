package kr.hs.dgsw.data.repository

import io.reactivex.Single
import kr.hs.dgsw.data.datasource.AccountDataSource
import kr.hs.dgsw.domain.entity.Account
import kr.hs.dgsw.domain.repository.AccountRepository

class AccountRepositoryImpl(
    private val accountDataSource: AccountDataSource
) : AccountRepository {
    override fun getAllAccount(): Single<List<Account>> =
        accountDataSource.getAllAccount()

    override fun getOtherAccount(): Single<List<Account>> =
        accountDataSource.getAccountOtherBank()

    override fun getMyAccountByToken(): Single<List<Account>> =
        accountDataSource.getMyAccountByToken()

    override fun getAccountByPhoneNumber(phone: String): Single<List<Account>> {
        TODO("Not yet implemented")
    }

    override fun getAccountByAccountNumber(accountNum: String): Single<List<Account>> =
        accountDataSource.getAccountByAccountNumber(accountNum)

    override fun findAccountNumber(accountNum: String): Single<List<String>> {
        TODO("Not yet implemented")
    }

    override fun getAllAsset(): Single<Int> {
        TODO("Not yet implemented")
    }

    override fun getAllAssetOtherAsset(): Single<Int> {
        TODO("Not yet implemented")
    }

    override fun postAccount(name: String, password: String): Single<String> {
        TODO("Not yet implemented")
    }

    override fun addAccount(
        accountNum: String,
        name: String,
        password: String,
        pay: Int,
    ): Single<String> {
        TODO("Not yet implemented")
    }

    override fun moveAssetMyAccount(
        sendAccountNum: String,
        receiveAccountNum: String,
        receiveAccountPw: String,
        transactionPay: Int,
    ): Single<String> {
        TODO("Not yet implemented")
    }
}
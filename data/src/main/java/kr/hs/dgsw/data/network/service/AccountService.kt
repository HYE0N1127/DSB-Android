package kr.hs.dgsw.data.network.service

import io.reactivex.Single
import kr.hs.dgsw.data.base.BaseResponse
import kr.hs.dgsw.domain.entity.Account
import kr.hs.dgsw.domain.response.account.LookUpAccountResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AccountService {

    @GET("/account/find")
    fun getAllAccount() : Single<retrofit2.Response<BaseResponse<List<Account>>>>

    @GET("/account/find/other")
    fun getAccountOtherBank() : Single<retrofit2.Response<BaseResponse<List<Account>>>>

    @GET("/account/find/token")
    fun getMyAccountByToken() : Single<retrofit2.Response<BaseResponse<List<Account>>>>

    @GET("/account/find/account")
    fun getPassword(
        @Path("accountNum") accountNum : String,
        @Path("accountPw") accountPw : String
    ) : Single<retrofit2.Response<BaseResponse<Any>>>

    @GET("/account/find/account/{account}")
    fun getAccountByAccountNumber(
        @Path("account") accountNumber : String
    ) : Single<retrofit2.Response<BaseResponse<LookUpAccountResponse>>>
}
package kr.hs.dgsw.data.network.service

import io.reactivex.Single
import kr.hs.dgsw.data.base.BaseResponse
import kr.hs.dgsw.domain.response.auth.LoginData
import kr.hs.dgsw.domain.request.auth.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthService {

    @POST("/auth/signin")
    fun login(
        @Body loginRequest: LoginRequest,
    ): Single<retrofit2.Response<BaseResponse<LoginData>>>

    @POST("/auth/signup")
    fun register(
        @Body registerRequest: RegisterRequest,
    ): Single<retrofit2.Response<BaseResponse<Any>>>

    @POST("/auth/signin/easy")
    fun simpleLogin(@Body easyLoginRequest: EasyLoginRequest): Single<retrofit2.Response<BaseResponse<LoginData>>>

    // 간편 로그인 번호 등록하는 API
    @POST("/auth/signup/easy")
    fun registerSimpleLogin(@Body easySignUpRequest: EasySignUpRequest): Single<retrofit2.Response<BaseResponse<Any>>>

    @GET("/auth/signup/check")
    fun idDoubleValidCheck(
        @Query("id") id: String
    ): Single<retrofit2.Response<BaseResponse<Any>>>

}
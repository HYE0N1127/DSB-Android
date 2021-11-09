package kr.hs.dgsw.data.network.service

import io.reactivex.Single
import kr.hs.dgsw.data.network.response.Response
import kr.hs.dgsw.data.network.response.data.LoginData
import kr.hs.dgsw.domain.request.auth.*
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("/auth/signin")
    fun login(
        @Body loginRequest: LoginRequest,
    ): Single<retrofit2.Response<Response<LoginData>>>

    @POST("auth/signup")
    fun register(
        @Body registerRequest: RegisterRequest,
    ): Single<retrofit2.Response<Response<Any>>>

    @POST("/auth/signin/easy")
    fun simpleLogin(@Body easyLoginRequest: EasyLoginRequest): Single<retrofit2.Response<Response<LoginData>>>

    // 간편 로그인 번호 등록하는 API
    @POST("/auth/signup/easy")
    fun registerSimpleLogin(@Body easySignUpRequest: EasySignUpRequest): Single<retrofit2.Response<Response<Any>>>

    @POST("auth/signup/check")
    fun idDoubleValidCheck(@Body idDoubleValidRequest: IdDoubleValidRequest): Single<retrofit2.Response<Response<Any>>>

}
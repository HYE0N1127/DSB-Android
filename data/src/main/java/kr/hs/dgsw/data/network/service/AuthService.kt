package kr.hs.dgsw.data.network.service

import io.reactivex.Single
import kr.hs.dgsw.data.network.request.LoginRequest
import kr.hs.dgsw.data.network.request.RegisterRequest
import kr.hs.dgsw.data.network.response.Response
import kr.hs.dgsw.data.network.response.data.LoginData
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("/auth/signin")
    fun login(
        @Body loginRequest: LoginRequest
    ): Single<retrofit2.Response<Response<LoginData>>>

    @POST("auth/signup")
    fun register(
        @Body registerRequest: RegisterRequest
    ): Single<retrofit2.Response<Response<Any>>>

    @POST("/auth/signin/easy")
    fun simpleLogin(): Single<retrofit2.Response<Response<Any>>>

    @POST("/auth/signup/easy")
    fun registerSimpleLogin(): Single<retrofit2.Response<Response<Any>>>

}
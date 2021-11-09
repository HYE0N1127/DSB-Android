package kr.hs.dgsw.data.network.remote

import io.reactivex.Single
import kr.hs.dgsw.data.base.BaseRemote
import kr.hs.dgsw.data.network.response.data.LoginData
import kr.hs.dgsw.data.network.service.AuthService
import kr.hs.dgsw.domain.request.auth.*

class AuthRemote(override val service: AuthService) : BaseRemote<AuthService>() {

    fun login(loginRequest: LoginRequest) : Single<LoginData> =
        service.login(loginRequest).map(getResponseData())

    fun register(registerRequest: RegisterRequest) =
        service.register(registerRequest).map(getResponseMessage())

    fun idDoubleValidCheck(idDoubleValidRequest: IdDoubleValidRequest) =
        service.idDoubleValidCheck(idDoubleValidRequest).map(getResponseMessage())

    fun simpleLogin(easyLoginRequest: EasyLoginRequest) =
        service.simpleLogin(easyLoginRequest).map(getResponseData())

    fun registerSimpleLogin(easySignUpRequest: EasySignUpRequest) =
        service.registerSimpleLogin(easySignUpRequest).map(getResponseMessage())
}
package kr.hs.dgsw.data.network.remote

import io.reactivex.Single
import kr.hs.dgsw.data.base.BaseRemote
import kr.hs.dgsw.data.network.request.LoginRequest
import kr.hs.dgsw.data.network.request.RegisterRequest
import kr.hs.dgsw.data.network.response.data.LoginData
import kr.hs.dgsw.data.network.service.AuthService

class AuthRemote(override val service: AuthService) : BaseRemote<AuthService>() {

    fun login(loginRequest: LoginRequest) : Single<String> =
        service.login(loginRequest).map(getResponseData()).map(LoginData::token)

    fun register(registerRequest: RegisterRequest) =
        service.register(registerRequest).map(getResponseMessage())
}
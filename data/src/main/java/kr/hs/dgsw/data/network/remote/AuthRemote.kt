package kr.hs.dgsw.data.network.remote

import kr.hs.dgsw.data.base.BaseRemote
import kr.hs.dgsw.data.network.request.LoginRequest
import kr.hs.dgsw.data.network.request.RegisterRequest
import kr.hs.dgsw.data.network.service.AuthService
import javax.inject.Inject

class AuthRemote @Inject constructor(override val service: AuthService) : BaseRemote<AuthService>() {

    fun login(loginRequest: LoginRequest) =
        service.login(loginRequest).map(getResponseData())

    fun register(registerRequest: RegisterRequest) =
        service.register(registerRequest).map(getResponseMessage())
}
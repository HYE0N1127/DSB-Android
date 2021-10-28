package kr.hs.dgsw.data.datasource

import kr.hs.dgsw.data.base.BaseDataSource
import kr.hs.dgsw.data.network.remote.AuthRemote
import kr.hs.dgsw.data.network.request.LoginRequest

class AuthDataSource(override val remote: AuthRemote, override val cache: Any) : BaseDataSource<AuthRemote, Any>() {
    fun login(loginRequest: LoginRequest) = remote.login(loginRequest)
}
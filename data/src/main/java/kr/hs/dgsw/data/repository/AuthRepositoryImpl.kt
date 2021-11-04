package kr.hs.dgsw.data.repository

import io.reactivex.Completable
import kr.hs.dgsw.data.network.remote.AuthRemote
import kr.hs.dgsw.data.network.request.LoginRequest
import kr.hs.dgsw.domain.repository.AuthRepository

class AuthRepositoryImpl(private val authRemote: AuthRemote) : AuthRepository {
    override fun register(id: String, pw: String, name: String): Completable {
        TODO("Not yet implemented")
    }

    override fun login(id: kr.hs.dgsw.domain.request.LoginRequest, pw: String): Completable =
        authRemote.login(LoginRequest(id, pw)).ignoreElement()

    override fun simpleLogin(simplePw: String): Completable {
        TODO("Not yet implemented")
    }

}
package kr.hs.dgsw.data.repository

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.data.datasource.AuthDataSource
import kr.hs.dgsw.data.datasource.TokenDataSource
import kr.hs.dgsw.data.network.request.LoginRequest
import kr.hs.dgsw.data.network.response.data.LoginData
import kr.hs.dgsw.domain.entity.Token
import kr.hs.dgsw.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authDataSource: AuthDataSource,
    private val tokenDataSource: TokenDataSource
) : AuthRepository {
    override fun register(id: String, pw: String, name: String): Completable {
        TODO("Not yet implemented")
    }

    override fun login(id: String, pw: String): Completable {
        return authDataSource.login(LoginRequest(id, pw)).flatMapCompletable {
                tokenDataSource.setToken(Token(it.token, it.easyPwIdx))
        }
    }

    override fun simpleLogin(simplePw: String): Completable {
        TODO("Not yet implemented")
    }
}
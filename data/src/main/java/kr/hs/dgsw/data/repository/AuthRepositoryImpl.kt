package kr.hs.dgsw.data.repository

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.data.database.TokenCache
import kr.hs.dgsw.data.datasource.AuthDataSource
import kr.hs.dgsw.data.datasource.TokenDatasource
import kr.hs.dgsw.data.network.remote.AuthRemote
import kr.hs.dgsw.data.network.response.data.LoginData
import kr.hs.dgsw.domain.entity.Token
import kr.hs.dgsw.domain.repository.AuthRepository
import kr.hs.dgsw.domain.request.LoginRequest

class AuthRepositoryImpl(
    private val authDataSource: AuthDataSource,
    private val tokenDatasource: TokenDatasource,
) : AuthRepository {

    override fun register(id: String, pw: String, name: String): Completable {
        TODO("Not yet implemented")
    }

    override fun login(id: String, pw: String): Completable =
        authDataSource.login(LoginRequest(id, pw)).flatMapCompletable {
            tokenDatasource.setToken(Token(it.token, it.easyPwIdx))
        }


    override fun simpleLogin(simplePw: String): Completable {
        TODO("Not yet implemented")
    }

}
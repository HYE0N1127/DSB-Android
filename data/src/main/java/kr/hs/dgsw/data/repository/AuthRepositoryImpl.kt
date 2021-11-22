package kr.hs.dgsw.data.repository

import io.reactivex.Completable
import kr.hs.dgsw.data.datasource.AuthDataSource
import kr.hs.dgsw.data.datasource.TokenDatasource
import kr.hs.dgsw.domain.entity.Token
import kr.hs.dgsw.domain.repository.AuthRepository
import kr.hs.dgsw.domain.request.auth.*

class AuthRepositoryImpl(
    private val authDataSource: AuthDataSource,
    private val tokenDatasource: TokenDatasource,
) : AuthRepository {

    override fun register(
        id: String,
        pw: String,
        name: String,
        nickname : String,
        phone : String,
        birth : String,
        profileImage : String
    ): Completable =
        authDataSource.register(RegisterRequest(id, pw, name, nickname, phone, birth, profileImage) )

    override fun login(id: String, pw: String): Completable =
        authDataSource.login(LoginRequest(id, pw)).flatMapCompletable {
            tokenDatasource.setToken(Token(it.token, it.easyPwIdx))
        }

    override fun simpleRegister(userId: String, easyPassword: String): Completable =
        authDataSource.registerSimpleLogin(EasySignUpRequest(userId, easyPassword))

    override fun simpleLogin(idx: String, simplePassword: String): Completable =
        authDataSource.simpleLogin(EasyLoginRequest(idx, simplePassword)).flatMapCompletable {
            tokenDatasource.setToken(Token(it.token, it.easyPwIdx))
        }

    override fun idDoubleValidCheck(id: String): Completable =
        authDataSource.idDoubleValidCheck(id)

}
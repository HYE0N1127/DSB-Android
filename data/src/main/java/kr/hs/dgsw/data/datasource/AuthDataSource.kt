package kr.hs.dgsw.data.datasource

import io.reactivex.Completable
import kr.hs.dgsw.data.base.BaseDataSource
import kr.hs.dgsw.data.database.TokenCache
import kr.hs.dgsw.data.mapper.TokenMapper
import kr.hs.dgsw.data.network.remote.AuthRemote
import kr.hs.dgsw.domain.request.auth.*

class AuthDataSource(override val remote: AuthRemote, override val cache: TokenCache) :
    BaseDataSource<AuthRemote, TokenCache>() {

    private val tokenMapper = TokenMapper()

    fun login(loginRequest: LoginRequest) =
        remote.login(loginRequest).map(tokenMapper::mapToModel)

    fun register(registerRequest: RegisterRequest) =
        remote.register(registerRequest).flatMapCompletable { Completable.complete() }

    fun simpleLogin(easyLoginRequest: EasyLoginRequest) =
        remote.simpleLogin(easyLoginRequest).map(tokenMapper::mapToModel)

    fun registerSimpleLogin(easySignUpRequest: EasySignUpRequest) =
        remote.registerSimpleLogin(easySignUpRequest).flatMapCompletable { Completable.complete() }

    fun idDoubleValidCheck(idDoubleValidRequest: IdDoubleValidRequest) =
        remote.idDoubleValidCheck(idDoubleValidRequest).flatMapCompletable { Completable.complete() }
}
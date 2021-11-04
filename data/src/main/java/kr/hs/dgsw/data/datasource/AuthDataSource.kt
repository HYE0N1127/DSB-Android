package kr.hs.dgsw.data.datasource

import kr.hs.dgsw.data.base.BaseDataSource
import kr.hs.dgsw.data.database.TokenCache
import kr.hs.dgsw.data.mapper.TokenMapper
import kr.hs.dgsw.data.network.remote.AuthRemote
import kr.hs.dgsw.domain.request.LoginRequest

class AuthDataSource(override val remote: AuthRemote, override val cache: TokenCache) :
    BaseDataSource<AuthRemote, TokenCache>() {

    private val tokenMapper = TokenMapper()

        fun login(loginRequest: LoginRequest) =
            remote.login(loginRequest).map(tokenMapper::mapToModel)
}
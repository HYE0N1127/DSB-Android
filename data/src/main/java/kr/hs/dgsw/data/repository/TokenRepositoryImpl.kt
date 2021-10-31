package kr.hs.dgsw.data.repository

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.data.datasource.TokenDataSource
import kr.hs.dgsw.domain.entity.Token
import kr.hs.dgsw.domain.repository.TokenRepository
import javax.inject.Inject

class TokenRepositoryImpl @Inject constructor(
    private val tokenDataSource: TokenDataSource
) : TokenRepository {

    override fun getToken(): Single<Token> {
        return tokenDataSource.getToken()
    }

    override fun deleteToken(): Completable {
        TODO("Not yet implemented")
    }

}
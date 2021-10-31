package kr.hs.dgsw.domain.repository

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.domain.entity.Token

interface TokenRepository {
    fun getToken() : Single<Token>

    fun deleteToken() : Completable
}
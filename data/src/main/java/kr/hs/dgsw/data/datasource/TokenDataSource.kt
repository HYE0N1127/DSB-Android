package kr.hs.dgsw.data.datasource

import kr.hs.dgsw.data.base.BaseDataSource
import kr.hs.dgsw.data.database.TokenCache
import kr.hs.dgsw.domain.entity.Token
import javax.inject.Inject

class TokenDataSource @Inject constructor(
    override val remote: Any,
    override val cache: TokenCache
): BaseDataSource<Any, TokenCache>() {

    fun getToken() = cache.getToken()

    fun setToken(token : Token) = cache.setToken(token)

    fun deleteToken() = cache.deleteToken()


}
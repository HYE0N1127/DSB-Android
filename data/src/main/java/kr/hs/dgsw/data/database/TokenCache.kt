package kr.hs.dgsw.data.database

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.domain.entity.Token

class TokenCache {

    fun getToken(): Single<Token> {
        val token = Token(
            Preferences.preferences.getString("token", null) ?: "",
            Preferences.preferences.getString("easyPwIdx", null) ?: ""
        )

        return Single.just(token)
    }

    fun setToken(token: Token): Completable {
        Preferences.preferences.edit()
            .putString("token", token.token)
            .putString("refreshToken", token.easyPwIdx)
            .apply()

        return Completable.complete()
    }

    fun deleteToken(): Completable {
        Preferences.preferences.edit().remove("token").remove("refreshToken").apply()
        return Completable.complete()
    }
}
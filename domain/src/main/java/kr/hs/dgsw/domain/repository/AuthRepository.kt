package kr.hs.dgsw.domain.repository

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.domain.entity.Token
import kr.hs.dgsw.domain.request.LoginRequest

interface AuthRepository {

    fun register(id: String, pw: String, name: String) : Completable

    fun login(id: String, pw: String) : Completable

    fun simpleLogin(simplePw : String) : Completable

}
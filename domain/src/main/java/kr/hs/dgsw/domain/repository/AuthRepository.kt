package kr.hs.dgsw.domain.repository

import io.reactivex.Completable

interface AuthRepository {

    fun register(id: String, pw: String, name: String) : Completable

    fun login(id: String, pw: String) : Completable

    fun simpleRegister(userId: String, easyPassword: String) : Completable

    fun simpleLogin(simplePw : String) : Completable

    fun idDoubleValidCheck(id: String) : Completable

}
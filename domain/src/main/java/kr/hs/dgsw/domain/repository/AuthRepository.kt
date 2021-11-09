package kr.hs.dgsw.domain.repository

import io.reactivex.Completable

interface AuthRepository {

    fun register(
        id: String,
        pw: String,
        name: String,
        nickname: String,
        phone: String,
        birth: String,
        profileImage: String,
    ): Completable

    fun login(id: String, pw: String): Completable

    fun simpleRegister(userId: String, easyPassword: String): Completable

    fun simpleLogin(idx: String, simplePassword: String): Completable

    fun idDoubleValidCheck(id: String): Completable

}
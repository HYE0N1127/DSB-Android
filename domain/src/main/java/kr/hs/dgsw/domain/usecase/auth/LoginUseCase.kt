package kr.hs.dgsw.domain.usecase.auth

import io.reactivex.Completable
import io.reactivex.Single
import kr.hs.dgsw.domain.base.ParamUseCase
import kr.hs.dgsw.domain.entity.Token
import kr.hs.dgsw.domain.repository.AuthRepository
import kr.hs.dgsw.domain.request.LoginRequest

class LoginUseCase(private val authRepository: AuthRepository) :
    ParamUseCase<LoginUseCase.Params, Completable> {

    override fun buildUseCaseObservable(params: Params): Completable {
        return authRepository.login(params.id, params.password)
    }

    data class Params (
        val id: String,
        val password: String
    )
}
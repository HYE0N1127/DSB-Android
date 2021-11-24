package kr.hs.dgsw.domain.usecase.auth

import io.reactivex.Completable
import kr.hs.dgsw.domain.base.ParamUseCase
import kr.hs.dgsw.domain.repository.AuthRepository

class IdDoubleValidUseCase(private val authRepository: AuthRepository) :
    ParamUseCase<IdDoubleValidUseCase.Params, Completable> {

    override fun buildUseCaseObservable(params: Params): Completable {
        return authRepository.idDoubleValidCheck(params.id)
    }

    data class Params(
        val id: String,
    )
}
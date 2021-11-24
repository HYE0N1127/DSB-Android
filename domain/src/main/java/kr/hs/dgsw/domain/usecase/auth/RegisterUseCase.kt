package kr.hs.dgsw.domain.usecase.auth

import io.reactivex.Completable
import kr.hs.dgsw.domain.base.ParamUseCase
import kr.hs.dgsw.domain.repository.AuthRepository

class RegisterUseCase(private val authRepository: AuthRepository) :
    ParamUseCase<RegisterUseCase.Params, Completable> {

    override fun buildUseCaseObservable(params: Params): Completable {
        return authRepository.register(
            params.id,
            params.password,
            params.name,
            params.nickname,
            params.phone,
            params.birth,
            params.profileImage
        )
    }

    data class Params(
        val id: String,
        val password: String,
        val name: String,
        val nickname: String,
        val phone: String,
        val birth: String,
        val profileImage: String,
    )
}
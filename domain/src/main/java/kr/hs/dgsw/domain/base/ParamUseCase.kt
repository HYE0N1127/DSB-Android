package kr.hs.dgsw.domain.base

interface ParamUseCase<Params, T> {
    fun buildUseCaseObservable(params: Params) : T
}
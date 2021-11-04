package kr.hs.dgsw.data.base

abstract class BaseUseCase<out T> {
    abstract fun buildUseCaseObservable(): T

}
package kr.hs.dgsw.dsb_android.module

import kr.hs.dgsw.domain.usecase.auth.LoginUseCase
import org.koin.dsl.module

val UseCaseModule = module {
    single { LoginUseCase(get()) }
}
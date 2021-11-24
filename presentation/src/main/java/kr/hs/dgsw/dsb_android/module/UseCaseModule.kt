package kr.hs.dgsw.dsb_android.module

import kr.hs.dgsw.domain.usecase.auth.IdDoubleValidUseCase
import kr.hs.dgsw.domain.usecase.auth.LoginUseCase
import kr.hs.dgsw.domain.usecase.auth.RegisterUseCase
import org.koin.dsl.module

val UseCaseModule = module {
    single { LoginUseCase(get()) }
    single { RegisterUseCase(get()) }
    single { IdDoubleValidUseCase(get()) }
}
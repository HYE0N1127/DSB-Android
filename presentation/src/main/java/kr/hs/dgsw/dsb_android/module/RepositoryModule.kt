package kr.hs.dgsw.dsb_android.module

import kr.hs.dgsw.data.repository.AuthRepositoryImpl
import kr.hs.dgsw.domain.repository.AuthRepository
import org.koin.dsl.module

val RepositoryModule = module {
    single<AuthRepository> { AuthRepositoryImpl(get(), get()) }
}
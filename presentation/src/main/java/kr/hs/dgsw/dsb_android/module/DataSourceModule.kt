package kr.hs.dgsw.dsb_android.module

import kr.hs.dgsw.data.datasource.AuthDataSource
import org.koin.dsl.module

val DataSourceModule = module {
    single<AuthDataSource> { AuthDataSource(get(), get()) }
}
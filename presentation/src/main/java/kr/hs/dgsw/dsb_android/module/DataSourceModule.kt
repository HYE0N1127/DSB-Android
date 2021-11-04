package kr.hs.dgsw.dsb_android.module

import kr.hs.dgsw.data.datasource.AuthDataSource
import kr.hs.dgsw.data.datasource.TokenDatasource
import org.koin.dsl.module

val DataSourceModule = module {
    single { AuthDataSource(get(), get()) }
    single { TokenDatasource(Any(), get())}
}
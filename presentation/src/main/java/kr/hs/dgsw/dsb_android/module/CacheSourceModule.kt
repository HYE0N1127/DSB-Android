package kr.hs.dgsw.dsb_android.module

import kr.hs.dgsw.data.database.TokenCache
import org.koin.dsl.module

val CacheSourceModule = module {
    single { TokenCache() }
}
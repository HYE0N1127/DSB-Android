package kr.hs.dgsw.dsb_android.module

import kr.hs.dgsw.data.network.service.AuthService
import org.koin.dsl.module
import retrofit2.Retrofit

val ServiceModule = module{
    single { (get() as Retrofit).create(AuthService::class.java) }
}
package kr.hs.dgsw.dsb_android.module

import kr.hs.dgsw.data.network.remote.AuthRemote
import kr.hs.dgsw.data.network.service.AuthService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

val RemoteModule = module {
    single<AuthRemote> { AuthRemote(get()) }

}
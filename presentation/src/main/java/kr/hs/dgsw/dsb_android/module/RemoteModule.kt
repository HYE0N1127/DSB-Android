package kr.hs.dgsw.dsb_android.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.data.network.remote.AuthRemote
import kr.hs.dgsw.data.network.service.AuthService
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class DefaultRetrofit

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class NoTokenInterceptorRetrofit

    @Provides
    fun provideAuthRemote(@DefaultRetrofit retrofit: Retrofit) : AuthRemote {
        return AuthRemote(retrofit.create(AuthService::class.java))
    }
}
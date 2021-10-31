package kr.hs.dgsw.dsb_android.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.data.database.TokenCache
import kr.hs.dgsw.data.datasource.AuthDataSource
import kr.hs.dgsw.data.datasource.TokenDataSource
import kr.hs.dgsw.data.network.remote.AuthRemote
import kr.hs.dgsw.domain.repository.AuthRepository

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    fun provideAuthDataSource(remote: AuthRemote): AuthDataSource =
        AuthDataSource(remote, Any())

    @Provides
    fun tokenDataSource(remote: Any) : TokenDataSource =
        TokenDataSource(remote, TokenCache())
}
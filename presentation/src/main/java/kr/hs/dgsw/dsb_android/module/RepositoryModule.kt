package kr.hs.dgsw.dsb_android.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.data.datasource.AuthDataSource
import kr.hs.dgsw.data.datasource.TokenDataSource
import kr.hs.dgsw.data.repository.AuthRepositoryImpl
import kr.hs.dgsw.data.repository.TokenRepositoryImpl
import kr.hs.dgsw.domain.repository.AuthRepository
import kr.hs.dgsw.domain.repository.TokenRepository

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideAuthRepository(authDataSource: AuthDataSource, tokenDataSource: TokenDataSource): AuthRepository =
        AuthRepositoryImpl(authDataSource, tokenDataSource)

    @Provides
    fun provideTokenRepository(tokenDataSource: TokenDataSource): TokenRepository =
        TokenRepositoryImpl(tokenDataSource)
}
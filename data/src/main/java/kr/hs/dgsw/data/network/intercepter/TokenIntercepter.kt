package kr.hs.dgsw.data.network.intercepter

import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import kr.hs.dgsw.data.exception.TokenException
import kr.hs.dgsw.domain.entity.Token
import kr.hs.dgsw.domain.repository.TokenRepository
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class TokenInterceptor @Inject constructor(
    private val tokenRepository: TokenRepository,
) :
    Interceptor {

    private val disposable = CompositeDisposable()

    private lateinit var token: Token

    override fun intercept(chain: Interceptor.Chain): Response {
        disposable.add(tokenRepository.getToken().subscribe({ token = it }, {}))

        val request =
            if (::token.isInitialized) chain.request().newBuilder()
                .addHeader("x-access-token", token.token).build()
            else chain.request()

        disposable.dispose()

        val response = chain.proceed(request)

        when (response.code) {
            410 -> {
                disposable.add(tokenRepository.deleteToken().subscribe({
                    disposable.dispose()
                }, {}))
                throw TokenException("세션이 만료되었습니다")
            }
            else -> {
                disposable.dispose()
                return response
            }
        }
    }

}
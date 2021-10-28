package kr.hs.dgsw.dsb_android.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.data.network.intercepter.TokenInterceptor
import kr.hs.dgsw.data.utils.Constants
import kr.hs.dgsw.domain.repository.TokenRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executors
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class DefaultOkHttpClient

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class NoTokenInterceptorOkHttpClient

    @Provides
    fun provideTokenInterceptor(tokenRepository: TokenRepository): TokenInterceptor {
        return TokenInterceptor(tokenRepository)
    }

    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @DefaultOkHttpClient
    @Provides
    fun provideOkHttpClient(tokenInterceptor: TokenInterceptor): OkHttpClient {
        return OkHttpClient().newBuilder()
            .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor(tokenInterceptor)
            .build()
    }

    @NoTokenInterceptorOkHttpClient
    @Provides
    fun provideNoTokenInterceptorOkHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder()
            .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    @RemoteModule.DefaultRetrofit
    @Provides
    fun provideRetrofit(gson: Gson, @DefaultOkHttpClient okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(Constants.SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .callbackExecutor(Executors.newSingleThreadExecutor())
            .build()
    }

    @RemoteModule.NoTokenInterceptorRetrofit
    @Provides
    fun provideNoTokenInterceptorRetrofit(
        gson: Gson,
        @NoTokenInterceptorOkHttpClient okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(Constants.SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .callbackExecutor(Executors.newSingleThreadExecutor())
            .build()
    }
}
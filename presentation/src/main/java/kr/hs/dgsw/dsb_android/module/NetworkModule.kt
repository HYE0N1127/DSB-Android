package kr.hs.dgsw.dsb_android.module

import kr.hs.dgsw.data.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val NetworkModule = module{

    val networkModule = module {

        single {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            OkHttpClient.Builder().addInterceptor(interceptor)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS).build()
        }

        single {
            RxJava2CallAdapterFactory.create() as CallAdapter.Factory
        }

        single {
            GsonConverterFactory.create() as Converter.Factory
        }

        single {
            Retrofit.Builder()
                .baseUrl(Constants.SERVER_URL)
                .client(get())
                .addConverterFactory(get())
                .addCallAdapterFactory(get())
                .build()
        }
    }
}
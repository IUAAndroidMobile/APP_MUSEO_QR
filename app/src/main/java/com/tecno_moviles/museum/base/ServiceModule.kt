package com.tecno_moviles.museum.base

import com.tecno_moviles.museum.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val RETROFIT_API_AUTH = "RetrofitAuthApi"
const val HTTP_CLIENT_AUTH = "OkHttpClientAuth"

const val TIMEOUT_API = 30L

val apiAuthModule = module {
    //Auth Api
    single() { providerHttpLoggingInterceptor() }
    single(named(HTTP_CLIENT_AUTH)) { providerHttpClientAuth(get()) }
    single(named(RETROFIT_API_AUTH)) {
        providerRetrofit(
            url = BuildConfig.BASE_URL,
            client = get(named(HTTP_CLIENT_AUTH))
        )
    }
}

fun providerRetrofit(url: String, client: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(url)
        .client(client)
        .build()
}

fun providerHttpClientAuth(
    httpLoggingInterceptor: HttpLoggingInterceptor?
): OkHttpClient {

    val httpClientBuilder = generateCustomClient(TIMEOUT_API)
    httpClientBuilder.addInterceptor { chain: Interceptor.Chain ->
        val builder = generateBasicRequest(chain, appPreferencesRepository)
        builder.addHeader(HEADER_APP_VERSION, BuildConfig.VERSION_NAME)
        builder.addHeader(HEADER_ACCESS_TOKEN, appPreferencesRepository.tokenM)
        builder.addHeader(HEADER_CLIENT_ID, BuildConfig.CI_TUNKI_ID)
        chain.proceed(builder.build())
    }
    if (httpLoggingInterceptor != null) {
        httpClientBuilder.addInterceptor(httpLoggingInterceptor)
    }

    httpClientBuilder.addInterceptor(ApiKotlinVersionInterceptor())
    return httpClientBuilder.build()
}

fun providerHttpLoggingInterceptor(): HttpLoggingInterceptor {
    val logging = HttpLoggingInterceptor()
    logging.level =
        if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
    return logging
}

fun generateCustomClient(timeout: Long): OkHttpClient.Builder {
    return OkHttpClient.Builder()
        .addInterceptor(BodyInterceptor())
        .connectTimeout(timeout, TimeUnit.SECONDS)
        .writeTimeout(timeout, TimeUnit.SECONDS)
        .readTimeout(timeout, TimeUnit.SECONDS)
}

class BodyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        return if (response.code == 204 || response.code == 205) {
            response
                .newBuilder()
                .code(200)
                .body(response.body)
                .build()
        } else {
            response
        }
    }
}
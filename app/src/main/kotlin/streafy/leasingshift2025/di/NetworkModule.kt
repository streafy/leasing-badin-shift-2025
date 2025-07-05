package streafy.leasingshift2025.di

import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import streafy.leasingshift2025.shared.di.ApplicationScope

const val BASE_URL = "https://shift-intensive.ru/api/"

@Module
class NetworkModule {

    @ApplicationScope
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val contentType = "application/json".toMediaType()
        val jsonConverterFactory = Json.asConverterFactory(contentType)

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(jsonConverterFactory)
            .client(okHttpClient)
            .build()
    }

    @ApplicationScope
    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient()
}
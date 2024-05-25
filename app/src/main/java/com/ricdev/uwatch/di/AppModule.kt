package com.ricdev.uwatch.di

import com.ricdev.uwatch.BuildConfig
import com.ricdev.uwatch.common.Constants
import com.ricdev.uwatch.data.remote.MovieDBApi
import com.ricdev.uwatch.data.repository.MoviesRepositoryImpl
import com.ricdev.uwatch.domain.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) //live as long as our application
object AppModule {



    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {

        val requestInterceptor = Interceptor { chain ->
            val url = chain.request()
                .url
                .newBuilder()
                .addQueryParameter("api_key", BuildConfig.API_KEY)
                .build()

            val request = chain.request()
                .newBuilder()
                .url(url)
                .build()

            return@Interceptor chain.proceed(request)
        }

        return OkHttpClient.Builder()
            .addInterceptor(requestInterceptor) // Add your API key here
            .build()
    }

    @Provides
    @Singleton
    fun provideMovieDBApi(okHttpClient: OkHttpClient): MovieDBApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieDBApi::class.java)
    }


    @Provides
    @Singleton
    fun provideMovieRepository(api: MovieDBApi): MoviesRepository {
        return MoviesRepositoryImpl(api)
    }

}
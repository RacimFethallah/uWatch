package com.ricdev.uwatch.di

import com.ricdev.uwatch.common.Constants
import com.ricdev.uwatch.data.remote.MovieDBApi
import com.ricdev.uwatch.data.repository.MoviesRepositoryImpl
import com.ricdev.uwatch.domain.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) //live as long as our application
object AppModule {


    @Provides
    @Singleton
    fun provideMovieDBApi(): MovieDBApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieDBApi::class.java)
    }


    @Provides
    @Singleton
    fun ProvideMovieRepository(api: MovieDBApi): MoviesRepository {
        return MoviesRepositoryImpl(api)
    }

}
package com.ricdev.uwatch.domain.repository

import androidx.paging.PagingData
import com.ricdev.uwatch.data.remote.dto.MovieDetailsDto
import com.ricdev.uwatch.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {

    suspend fun getTrendingMovies(): Flow<PagingData<Movie>>


    suspend fun getMovieDetails(
        movieId: Int
    ): MovieDetailsDto

}
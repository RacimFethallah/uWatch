package com.ricdev.uwatch.domain.repository

import com.ricdev.uwatch.common.Resource
import com.ricdev.uwatch.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    suspend fun getTrendingMovies(
        forceFetchFromRemote: Boolean,
        page: Int
    ): List<Movie>


    suspend fun getMovieDetails(
        movie_id: Int
    )
}
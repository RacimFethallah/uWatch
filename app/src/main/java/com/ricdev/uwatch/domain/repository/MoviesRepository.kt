package com.ricdev.uwatch.domain.repository

import com.ricdev.uwatch.common.Resource
import com.ricdev.uwatch.data.remote.dto.MovieDetailsDto
import com.ricdev.uwatch.data.remote.dto.MovieListDto
import com.ricdev.uwatch.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    suspend fun getTrendingMovies(
//        forceFetchFromRemote: Boolean,
        page: Int
    ): MovieListDto


    suspend fun getMovieDetails(
        movieId: Int
    ): MovieDetailsDto
}
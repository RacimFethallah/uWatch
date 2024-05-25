package com.ricdev.uwatch.data.remote

import com.ricdev.uwatch.data.remote.dto.MovieDetailsDto
import com.ricdev.uwatch.data.remote.dto.MovieListDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDBApi {

    @GET("discover/movie")
    suspend fun getTrendingMovies(
        @Query("page") page: Int,
    ): MovieListDto


    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int,
    ): MovieDetailsDto
}
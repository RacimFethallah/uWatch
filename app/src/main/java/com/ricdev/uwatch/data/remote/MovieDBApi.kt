package com.ricdev.uwatch.data.remote

import com.ricdev.uwatch.domain.model.MovieList
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieDBApi {
    @GET("discover/movie")
    suspend fun getTrendingMovies(
        @Path("page") page: Int,
//        @Path("api_key") api_key: String,
    )


    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movie_id: Int,
//        @Path("api_key") api_key: String,
    )
}
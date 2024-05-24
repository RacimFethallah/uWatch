package com.ricdev.uwatch.data.remote

import com.ricdev.uwatch.data.remote.dto.MovieDetailsDto
import com.ricdev.uwatch.data.remote.dto.MovieListDto
import com.ricdev.uwatch.domain.model.MovieDetails
import com.ricdev.uwatch.domain.model.MovieList
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieDBApi {

    //    https://api.themoviedb.org/3/movie/550?api_key=***
    //    https://api.themoviedb.org/3/discover/movie?api_key=***
    //    https://api.themoviedb.org/3/


    @GET("discover/movie")
    suspend fun getTrendingMovies(
        @Path("page") page: Int,
    ): MovieListDto


    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int,
    ): MovieDetailsDto
}
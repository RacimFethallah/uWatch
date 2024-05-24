package com.ricdev.uwatch.data.repository
import com.ricdev.uwatch.data.remote.MovieDBApi
import com.ricdev.uwatch.data.remote.dto.MovieDetailsDto
import com.ricdev.uwatch.data.remote.dto.MovieListDto
import com.ricdev.uwatch.domain.model.Movie
import com.ricdev.uwatch.domain.model.MovieList
import com.ricdev.uwatch.domain.repository.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val movieDBApi: MovieDBApi
): MoviesRepository {
    override suspend fun getTrendingMovies(
//        forceFetchFromRemote: Boolean,
        page: Int
    ) : MovieListDto {
        return movieDBApi.getTrendingMovies(page)
    }

    override suspend fun getMovieDetails(movieId: Int): MovieDetailsDto {
        return movieDBApi.getMovieDetails(movieId)
    }
}
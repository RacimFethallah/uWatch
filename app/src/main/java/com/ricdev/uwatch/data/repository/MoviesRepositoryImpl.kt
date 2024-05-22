package com.ricdev.uwatch.data.repository
import com.ricdev.uwatch.data.remote.MovieDBApi
import com.ricdev.uwatch.domain.model.Movie
import com.ricdev.uwatch.domain.repository.MoviesRepository
import com.ricdev.uwatch.utils.Credentials.Companion.API_KEY
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val movieDBApi: MovieDBApi
): MoviesRepository {
    override suspend fun getTrendingMovies(
        forceFetchFromRemote: Boolean,
        page: Int
    ): List<Movie> {
        return movieDBApi.getTrendingMovies(page, API_KEY)
    }

    override suspend fun getMovieDetails(movie_id: Int) {
        return movieDBApi.getMovieDetails(movie_id, API_KEY)
    }
}
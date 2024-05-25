package com.ricdev.uwatch.domain.use_case.get_trending_movies

import androidx.paging.PagingData
import com.ricdev.uwatch.domain.model.Movie
import com.ricdev.uwatch.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTrendingMoviesUseCase @Inject constructor(
    private val repository: MoviesRepository
) {
    suspend operator fun invoke(): Flow<PagingData<Movie>> {
        return repository.getTrendingMovies()
    }
}
package com.ricdev.uwatch.data.repository
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ricdev.uwatch.data.remote.MovieDBApi
import com.ricdev.uwatch.data.remote.dto.MovieDetailsDto
import com.ricdev.uwatch.domain.model.Movie
import com.ricdev.uwatch.domain.repository.MoviesRepository
import com.ricdev.uwatch.paging.MoviePagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val movieDBApi: MovieDBApi
): MoviesRepository {

    override suspend fun getTrendingMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(
                pageSize = 1,
                enablePlaceholders = false,
            ),
            pagingSourceFactory = { MoviePagingSource(movieDBApi) }
        ).flow
    }
    override suspend fun getMovieDetails(movieId: Int): MovieDetailsDto {
        return movieDBApi.getMovieDetails(movieId)
    }


}
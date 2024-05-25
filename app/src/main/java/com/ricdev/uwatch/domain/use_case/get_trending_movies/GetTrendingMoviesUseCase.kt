package com.ricdev.uwatch.domain.use_case.get_trending_movies

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ricdev.uwatch.common.Resource
import com.ricdev.uwatch.data.remote.dto.toMovieList
import com.ricdev.uwatch.domain.model.Movie
import com.ricdev.uwatch.domain.model.MovieList
import com.ricdev.uwatch.domain.repository.MoviesRepository
import com.ricdev.uwatch.paging.MoviePagingSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetTrendingMoviesUseCase @Inject constructor(
    private val repository: MoviesRepository
){
//    operator fun invoke(page: Int): Flow<Resource<MovieList>> = flow {
//        try {
//            emit(Resource.Loading<MovieList>())
//            val movieList = repository.getTrendingMovies(page).toMovieList()
//            emit(Resource.Success<MovieList>(movieList))
//        } catch (e: HttpException) {
//            emit(Resource.Error<MovieList>(message = e.message ?: "An unexpected error occurred"))
//        } catch (e: IOException) {
//            emit(Resource.Error<MovieList>(message = "Couldn't reach server. Check your internet connection."))
//        }
//    }
// operator fun invoke(): Flow<PagingData<Movie>> {
//
//
//}

//    suspend fun execute(): Flow<PagingData<Movie>> {
//        return repository.getTrendingMoviesFlow()
//    }
suspend operator fun invoke(): Flow<PagingData<Movie>> {
    return repository.getTrendingMoviesFlow()
}
}
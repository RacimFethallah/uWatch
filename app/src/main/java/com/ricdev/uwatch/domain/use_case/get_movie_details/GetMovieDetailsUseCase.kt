package com.ricdev.uwatch.domain.use_case.get_movie_details

import com.ricdev.uwatch.common.Resource
import com.ricdev.uwatch.data.remote.dto.toMovieDetails
import com.ricdev.uwatch.domain.model.MovieDetails
import com.ricdev.uwatch.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    private val repository: MoviesRepository
){
    operator fun invoke(movieId: Int): Flow<Resource<MovieDetails>> = flow {
        try {
            emit(Resource.Loading<MovieDetails>())
            val movieDetails = repository.getMovieDetails(movieId).toMovieDetails()
            emit(Resource.Success<MovieDetails>(movieDetails))
        } catch (e: HttpException) {
            emit(Resource.Error<MovieDetails>(message = e.message ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<MovieDetails>(message = "Couldn't reach server. Check your internet connection."))
        }
    }
}
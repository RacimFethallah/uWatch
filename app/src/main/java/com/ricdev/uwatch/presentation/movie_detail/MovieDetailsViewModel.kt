package com.ricdev.uwatch.presentation.movie_detail

import androidx.lifecycle.ViewModel
import com.ricdev.uwatch.domain.use_case.get_trending_movies.GetTrendingMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavBackStackEntry
import com.ricdev.uwatch.common.Constants
import com.ricdev.uwatch.common.Resource
import com.ricdev.uwatch.domain.model.MovieList
import com.ricdev.uwatch.domain.use_case.get_movie_details.GetMovieDetailsUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel(){

    private val _state = mutableStateOf(MovieDetailsState())
    val state: State<MovieDetailsState> = _state


    init {
        savedStateHandle.get<String>("movieId")?.let { movieId ->
            val movieIdInt = movieId.toIntOrNull()
            if (movieIdInt != null) {
                getMovieDetails(movieIdInt)
            }
        }
    }
    private fun getMovieDetails(movieId: Int) {
        getMovieDetailsUseCase(movieId).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = MovieDetailsState(isLoading = true)
                }

                is Resource.Success -> {
                    _state.value = MovieDetailsState(movie = result.data)
                }

                is Resource.Error -> {
                    _state.value =
                        MovieDetailsState(error = result.message ?: "An unexpected error occurred")
                }
            }
        }.launchIn(viewModelScope)
    }
    fun refreshMovieDetails(movieId: Int) {
        getMovieDetails(movieId)
    }
}
package com.ricdev.uwatch.presentation.movies_list

import androidx.lifecycle.ViewModel
import com.ricdev.uwatch.domain.use_case.get_trending_movies.GetTrendingMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.ricdev.uwatch.common.Resource
import com.ricdev.uwatch.domain.model.MovieList
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getTrendingMoviesUseCase: GetTrendingMoviesUseCase
) : ViewModel(){

    private val _state = mutableStateOf(MovieListState())
    val state: State<MovieListState> = _state


    init {
        getTrendingMovies()
    }
    private fun getTrendingMovies() {
        getTrendingMoviesUseCase(1).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = MovieListState(isLoading = true)
                }

                is Resource.Success -> {
                    _state.value =
                        MovieListState(movies = result.data ?: MovieList(0, emptyList(), 0, 0))
                }

                is Resource.Error -> {
                    _state.value =
                        MovieListState(error = result.message ?: "An unexpected error occurred")
                }
            }
        }.launchIn(viewModelScope)
    }
}
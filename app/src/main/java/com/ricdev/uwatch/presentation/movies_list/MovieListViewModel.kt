package com.ricdev.uwatch.presentation.movies_list

import androidx.lifecycle.ViewModel
import com.ricdev.uwatch.domain.use_case.get_trending_movies.GetTrendingMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.ricdev.uwatch.domain.model.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getTrendingMoviesUseCase: GetTrendingMoviesUseCase
) : ViewModel(){


    private val _trendingMovies = MutableStateFlow<PagingData<Movie>>(PagingData.empty())
    val trendingMovies: StateFlow<PagingData<Movie>> = _trendingMovies

    init {
        getTrendingMovies()
    }
    private fun getTrendingMovies() {
        viewModelScope.launch {
            getTrendingMoviesUseCase().cachedIn(viewModelScope).collectLatest { pagingData ->
                _trendingMovies.value = pagingData
            }
        }
    }
}



//private fun getTrendingMovies() {
//    getTrendingMoviesUseCase(1).onEach { result ->
//        when (result) {
//            is Resource.Loading -> {
//                _state.value = MovieListState(isLoading = true)
//            }
//
//            is Resource.Success -> {
//                _state.value =
//                    MovieListState(movies = result.data ?: MovieList(0, emptyList(), 0, 0))
//            }
//
//            is Resource.Error -> {
//                _state.value =
//                    MovieListState(error = result.message ?: "An unexpected error occurred")
//            }
//        }
//    }.launchIn(viewModelScope)
//}
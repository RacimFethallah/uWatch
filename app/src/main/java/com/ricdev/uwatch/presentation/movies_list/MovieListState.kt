package com.ricdev.uwatch.presentation.movies_list

import com.ricdev.uwatch.domain.model.MovieList

data class MovieListState(
    val isLoading: Boolean = false,
    val movies: MovieList = MovieList(0, emptyList(), 0, 0),
    val error: String = ""
)

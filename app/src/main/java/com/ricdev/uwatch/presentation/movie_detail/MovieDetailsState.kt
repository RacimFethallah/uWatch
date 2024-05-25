package com.ricdev.uwatch.presentation.movie_detail

import com.ricdev.uwatch.domain.model.MovieDetails

data class MovieDetailsState(
    val isLoading: Boolean = false,
    val movie: MovieDetails? = null,
    val error: String = ""
)

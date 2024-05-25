package com.ricdev.uwatch.presentation

sealed class ScreenNavigation(val route: String) {
    data object MovieListScreen : ScreenNavigation("movie_list_screen")
    data object MovieDetailScreen : ScreenNavigation("movie_detail_screen")

}
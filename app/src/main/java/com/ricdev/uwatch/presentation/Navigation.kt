package com.ricdev.uwatch.presentation

sealed class ScreenNavigation(val route: String) {
    object MovieListScreen : ScreenNavigation("movie_list_screen")
    object MovieDetailScreen : ScreenNavigation("movie_detail_screen")

}
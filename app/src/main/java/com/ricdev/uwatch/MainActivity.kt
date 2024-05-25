package com.ricdev.uwatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ricdev.uwatch.presentation.ScreenNavigation
import com.ricdev.uwatch.presentation.movie_detail.MovieDetailsScreen
import com.ricdev.uwatch.presentation.movies_list.MovieListScreen
import com.ricdev.uwatch.ui.theme.UWatchTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UWatchTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = ScreenNavigation.MovieListScreen.route
                    ){
                        composable(
                            route = ScreenNavigation.MovieListScreen.route
                        ){
                            MovieListScreen( navController = navController)
                        }
                        composable(
                            route = ScreenNavigation.MovieDetailScreen.route + "/{movieId}",
                        ){
                            MovieDetailsScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}
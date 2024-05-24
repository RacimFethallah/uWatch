package com.ricdev.uwatch.presentation.movies_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ricdev.uwatch.presentation.ScreenNavigation
import com.ricdev.uwatch.presentation.movies_list.components.MovieCardItem
import com.ricdev.uwatch.presentation.movies_list.components.MovieCardSkeleton

@Composable
fun MovieListScreen(
    navController: NavController,
    viewModel: MovieListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Scaffold(
        topBar = {
            Text(
                text = "Trending Movies",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(16.dp)
            )
        },
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            if (state.isLoading) {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(10) {
                        MovieCardSkeleton()
                    }
                }
            } else {
                if (state.error.isNotBlank()) {
                    Text(
                        text = state.error,
                        color = MaterialTheme.colorScheme.error,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                } else {
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(state.movies.results) { movie ->
                            MovieCardItem(
                                movie = movie,
                                onItemClick = {
                                    navController.navigate(ScreenNavigation.MovieDetailScreen.route + "/${it.id}")
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}





//Box(modifier = Modifier
//.fillMaxSize()
//.padding(top = 16.dp)) {
//
//}
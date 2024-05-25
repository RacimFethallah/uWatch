package com.ricdev.uwatch.presentation.movies_list

import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.FlowRowScopeInstance.align
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
//import androidx.paging.compose.collectAsLazyPagingItems
import com.ricdev.uwatch.presentation.ScreenNavigation
import com.ricdev.uwatch.presentation.movies_list.components.MovieCardItem
import com.ricdev.uwatch.presentation.movies_list.components.MovieCardSkeleton

@Composable
fun MovieListScreen(
    navController: NavController,
    viewModel: MovieListViewModel = hiltViewModel()
) {
//    val state = viewModel.state.value

    val lazyPagingItems = viewModel.trendingMovies.collectAsLazyPagingItems()

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
            when (lazyPagingItems.loadState.refresh) {
                is LoadState.Loading -> {
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(10) {
                            MovieCardSkeleton()
                        }
                    }
                }

                is LoadState.Error -> {
                    val error = (lazyPagingItems.loadState.refresh as LoadState.Error).error
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "An unexpected error occurred, check your internet connexion and retry",
                            color = MaterialTheme.colorScheme.error,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(horizontal = 20.dp)
                        )
                        IconButton(
                            onClick = { lazyPagingItems.retry() },
                            modifier = Modifier.padding(top = 16.dp)
                        ) {
                            Icon(Icons.Default.Refresh, contentDescription = "Refresh")
                        }
                    }
                }

                else -> {
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(lazyPagingItems.itemCount) { index ->
                            val movie = lazyPagingItems[index]
                            if (movie != null) {
                                MovieCardItem(
                                    movie = movie,
                                    onItemClick = {
                                        navController.navigate(ScreenNavigation.MovieDetailScreen.route + "/${it.id}")
                                    }
                                )
                            }
                        }

                        lazyPagingItems.apply {
                            when (loadState.append) {
                                is LoadState.Loading -> {
                                    item {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(8.dp),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            CircularProgressIndicator()
                                        }
                                    }
                                }

                                is LoadState.Error -> {
                                    item {
                                        MovieCardSkeleton()
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(8.dp),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Button(
                                                onClick = { lazyPagingItems.retry() }
                                            ) {
                                                Text("Retry")
                                            }
                                        }
                                    }
                                }

                                is LoadState.NotLoading -> {
                                    item {
                                        Text(
                                            text = "All items loaded",
                                            textAlign = TextAlign.Center,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(16.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


//Column(modifier = Modifier.padding(innerPadding)) {
//    if (state.isLoading) {
//        LazyColumn(modifier = Modifier.fillMaxSize()) {
//            items(10) {
//                MovieCardSkeleton()
//            }
//        }
//    } else {
//        if (state.error.isNotBlank()) {
//            Text(
//                text = state.error,
//                color = MaterialTheme.colorScheme.error,
//                textAlign = TextAlign.Center,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 20.dp)
//                    .align(Alignment.CenterHorizontally)
//            )
//        } else {
//            LazyColumn(modifier = Modifier.fillMaxSize()) {
//                items(state.movies.results) { movie ->
//                    MovieCardItem(
//                        movie = movie,
//                        onItemClick = {
//                            navController.navigate(ScreenNavigation.MovieDetailScreen.route + "/${it.id}")
//                        }
//                    )
//                }
//            }
//        }
//    }
//}


//Box(modifier = Modifier
//.fillMaxSize()
//.padding(top = 16.dp)) {
//
//}
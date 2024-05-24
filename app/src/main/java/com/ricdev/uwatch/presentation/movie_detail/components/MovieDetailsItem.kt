package com.ricdev.uwatch.presentation.movie_detail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ricdev.uwatch.domain.model.Movie
import com.ricdev.uwatch.domain.model.MovieDetails

@Composable
fun MovieDetailItem(
    movie: MovieDetails,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(text = movie.title, style = MaterialTheme.typography.titleMedium)
        Text(text = movie.overview, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(top = 8.dp))
        // Add more movie details as needed
    }
}

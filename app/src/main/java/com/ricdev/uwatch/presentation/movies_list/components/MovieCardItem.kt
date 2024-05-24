package com.ricdev.uwatch.presentation.movies_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
//import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.ricdev.uwatch.domain.model.Movie

@Composable
fun MovieCardItem(
    movie: Movie,
    onItemClick: (Movie) -> Unit
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(movie) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween

    ){
        Column {
            Text(
                text = movie.title,
                style = MaterialTheme.typography.titleMedium,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = movie.release_date,
                style = MaterialTheme.typography.bodyMedium
            )
        }

    }
}
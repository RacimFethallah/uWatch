package com.ricdev.uwatch.presentation.movie_detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.ricdev.uwatch.common.Constants
import com.ricdev.uwatch.domain.model.MovieDetails

@Composable
fun ImagePoster(movie: MovieDetails) {

    val imagePainter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(Constants.IMAGE_BASE_URL + movie.backdrop_path)
            .size(Size.ORIGINAL)
            .build()
    )

    val imageState = imagePainter.state

    when (imageState) {
        is coil.compose.AsyncImagePainter.State.Loading -> {
            ImageBox {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }

        is coil.compose.AsyncImagePainter.State.Error -> {
            ImageBox {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = movie.title,
                    tint = MaterialTheme.colorScheme.error,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

        is coil.compose.AsyncImagePainter.State.Success -> {
            Image(
                painter = imagePainter,
                contentDescription = movie.title,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .height(200.dp)
            )
        }

        else -> {
            ImageBox {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = movie.title,
                    tint = MaterialTheme.colorScheme.error,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}

@Composable
fun ImageBox(content: @Composable BoxScope.() -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(MaterialTheme.colorScheme.surfaceVariant)
    ) {
        content()
    }
}
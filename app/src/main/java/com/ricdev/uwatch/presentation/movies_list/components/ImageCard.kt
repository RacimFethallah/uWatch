package com.ricdev.uwatch.presentation.movies_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.ricdev.uwatch.common.Constants
import com.ricdev.uwatch.domain.model.Movie

@Composable
fun ImageCard(movie: Movie) {
    val imagePainter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(Constants.IMAGE_BASE_URL + movie.poster_path)
            .size(Size.ORIGINAL)
            .build()
    )

    val imageState = imagePainter.state

    when (imageState) {
        is AsyncImagePainter.State.Loading -> {
            ImageBox {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
        is AsyncImagePainter.State.Error -> {
            ImageBox {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = movie.title,
                    tint = MaterialTheme.colorScheme.error,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
        is AsyncImagePainter.State.Success -> {
            Image(
                painter = imagePainter,
                contentDescription = movie.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(100.dp)
                    .height(150.dp)
                    .clip(RoundedCornerShape(10.dp))
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
            .width(100.dp)
            .height(150.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
    ) {
        content()
    }
}

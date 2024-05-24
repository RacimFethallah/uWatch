package com.ricdev.uwatch.data.remote.dto

import com.ricdev.uwatch.domain.model.Movie

data class MovieDto(
    val adult: Boolean,
    val backdrop_path: String?,
    val genre_ids: List<Int>?,
    val id: Int?,
    val original_language: String?,
    val original_title: String?,
    val overview: String?,
    val popularity: Double?,
    val poster_path: String?,
    val release_date: String?,
    val title: String?,
    val video: Boolean?,
    val vote_average: Double?,
    val vote_count: Int?
)

fun MovieDto.toMovie(): Movie {
    return Movie(
        adult = adult,
        backdrop_path = backdrop_path.orEmpty(),
        genre_ids = genre_ids ?: emptyList(),
        id = id ?: 0,
        original_language = original_language.orEmpty(),
        original_title = original_title.orEmpty(),
        overview = overview.orEmpty(),
        popularity = popularity ?: 0.0,
        poster_path = poster_path.orEmpty(),
        release_date = release_date.orEmpty(),
        title = title.orEmpty(),
        video = video ?: false,
        vote_average = vote_average ?: 0.0,
        vote_count = vote_count ?: 0
    )
}

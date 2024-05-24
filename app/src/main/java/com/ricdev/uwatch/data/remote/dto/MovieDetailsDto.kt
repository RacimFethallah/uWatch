package com.ricdev.uwatch.data.remote.dto

import com.ricdev.uwatch.domain.model.MovieDetails

data class MovieDetailsDto(
    val adult: Boolean,
    val backdrop_path: String?,
    val belongs_to_collection: BelongsToCollection?,
    val budget: Int?,
    val genres: List<Genre>?,
    val homepage: String?,
    val id: Int?,
    val imdb_id: String?,
    val origin_country: List<String>?,
    val original_language: String?,
    val original_title: String?,
    val overview: String?,
    val popularity: Double?,
    val poster_path: String?,
    val production_companies: List<ProductionCompany>?,
    val production_countries: List<Any>?,
    val release_date: String?,
    val revenue: Int?,
    val runtime: Int?,
    val spoken_languages: List<SpokenLanguage>?,
    val status: String?,
    val tagline: String?,
    val title: String?,
    val video: Boolean?,
    val vote_average: Double?,
    val vote_count: Int?
)

fun MovieDetailsDto.toMovieDetails(): MovieDetails {
    return MovieDetails(
        adult = adult,
        backdrop_path = backdrop_path.orEmpty(),
        belongs_to_collection = belongs_to_collection ?: BelongsToCollection(0, "", "", ""),
        budget = budget ?: 0,
        genres = genres ?: emptyList(),
        homepage = homepage.orEmpty(),
        id = id ?: 0,
        imdb_id = imdb_id.orEmpty(),
        origin_country = origin_country ?: emptyList(),
        original_language = original_language.orEmpty(),
        original_title = original_title.orEmpty(),
        overview = overview.orEmpty(),
        popularity = popularity ?: 0.0,
        poster_path = poster_path.orEmpty(),
        production_companies = production_companies ?: emptyList(),
        production_countries = production_countries ?: emptyList(),
        release_date = release_date.orEmpty(),
        revenue = revenue ?: 0,
        runtime = runtime ?: 0,
        spoken_languages = spoken_languages ?: emptyList(),
        status = status.orEmpty(),
        tagline = tagline.orEmpty(),
        title = title.orEmpty(),
        video = video ?: false,
        vote_average = vote_average ?: 0.0,
        vote_count = vote_count ?: 0
    )
}
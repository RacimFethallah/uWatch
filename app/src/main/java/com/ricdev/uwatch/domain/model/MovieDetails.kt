package com.ricdev.uwatch.domain.model

import com.ricdev.uwatch.data.remote.dto.BelongsToCollection
import com.ricdev.uwatch.data.remote.dto.Genre
import com.ricdev.uwatch.data.remote.dto.ProductionCompany
import com.ricdev.uwatch.data.remote.dto.SpokenLanguage

data class MovieDetails(
    val adult: Boolean,
    val backdrop_path: String,
    val belongs_to_collection: BelongsToCollection,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    val imdb_id: String,
    val origin_country: List<String>,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val production_companies: List<ProductionCompany>,
    val production_countries: List<Any>,
    val release_date: String,
    val revenue: Int,
    val runtime: Int,
    val spoken_languages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)

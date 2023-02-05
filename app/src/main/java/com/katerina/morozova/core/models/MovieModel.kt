package com.katerina.morozova.core.models

data class MovieModel(
    val filmId: Int,
    val nameRu: String?,
    val nameEn: String?,
    val year: String,
    val genres: List<GenreModel>,
    val countries: List<CountryModel>,
    val description: String?,
    val posterUrl: String,
    val posterUrlPreview: String,
    val isFavorite: Boolean = false
)
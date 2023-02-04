package com.katerina.morozova.core.models

data class MovieDescriptionModel(
    val filmId: Int,
    val nameRu: String? = null,
    val nameEn: String? = null,
    val posterUrl: String,
    val year: String,
    val description: String? = null,
    val countries: List<CountryModel>,
    val genres: List<GenreModel>
)
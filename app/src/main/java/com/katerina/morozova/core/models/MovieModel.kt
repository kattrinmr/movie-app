package com.katerina.morozova.core.models

data class MovieModel(
    val filmId: Int,
    val nameRu: String,
    val year: String,
    val genres: List<GenreModel>,
    val posterUrl: String
)
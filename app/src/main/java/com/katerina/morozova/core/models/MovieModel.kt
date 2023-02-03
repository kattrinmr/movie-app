package com.katerina.morozova.core.models

data class MovieModel(
    val filmId: Int,
    val nameRu: String,
    val year: String,
    val genres: List<Genre>,
    val posterUrl: String
)

data class Genre(val genre: String) {
    override fun toString(): String {
        return genre
    }
}
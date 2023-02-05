package com.katerina.morozova.core.utils.converters

import com.katerina.morozova.core.models.MovieModel
import com.katerina.morozova.core.room.entities.MovieEntity

fun MovieEntity.toModel(): MovieModel {
    return MovieModel(
        filmId = this.filmId,
        nameRu = this.nameRu,
        nameEn = this.nameEn,
        year = this.year,
        genres = this.genres,
        posterUrl = this.posterUrl,
        description = this.description,
        countries = this.countries
    )
}

fun MovieEntity.toModelFavorite(): MovieModel {
    return MovieModel(
        filmId = this.filmId,
        nameRu = this.nameRu,
        nameEn = this.nameEn,
        year = this.year,
        genres = this.genres,
        posterUrl = this.posterUrl,
        description = this.description,
        countries = this.countries,
        isFavorite = true
    )
}

fun MovieModel.toMovieEntity(): MovieEntity {
    return MovieEntity(
        filmId = this.filmId,
        nameRu = this.nameRu,
        nameEn = this.nameEn,
        year = this.year,
        countries = this.countries,
        genres = this.genres,
        posterUrl = this.posterUrl,
        description = this.description,
        isFavorite = this.isFavorite
    )
}
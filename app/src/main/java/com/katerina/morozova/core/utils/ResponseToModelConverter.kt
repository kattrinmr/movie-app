package com.katerina.morozova.core.utils

import com.katerina.morozova.core.models.MovieDescriptionModel

fun MovieDescriptionResponse.toModel(): MovieDescriptionModel {
    return MovieDescriptionModel(
        this.filmId,
        this.nameRu,
        this.posterUrl,
        this.year,
        this.description,
        this.countries,
        this.genres
    )
}
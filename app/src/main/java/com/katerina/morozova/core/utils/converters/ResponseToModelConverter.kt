package com.katerina.morozova.core.utils.converters

import com.katerina.morozova.core.models.MovieDescriptionModel
import com.katerina.morozova.core.utils.responses.MovieDescriptionResponse

fun MovieDescriptionResponse.toModel(): MovieDescriptionModel {
    return MovieDescriptionModel(
        this.filmId,
        this.nameRu,
        this.nameEn,
        this.posterUrl,
        this.webUrl,
        this.year,
        this.description,
        this.countries,
        this.genres
    )
}
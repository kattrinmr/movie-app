package com.katerina.morozova.core.utils

import com.katerina.morozova.core.models.CountryModel
import com.katerina.morozova.core.models.GenreModel

data class MovieDescriptionResponse(
    val filmId: Int,
    val nameRu: String? = null,
    val nameEn: String? = null,
    val posterUrl: String,
    val year: String,
    val description: String? = null,
    val countries: List<CountryModel>,
    val genres: List<GenreModel>
)
package com.katerina.morozova.data.utils.responses

import com.katerina.morozova.data.models.CountryModel
import com.katerina.morozova.data.models.GenreModel

data class MovieDescriptionResponse(
    val filmId: Int,
    val nameRu: String? = null,
    val nameEn: String? = null,
    val posterUrl: String,
    val webUrl: String,
    val year: String,
    val description: String? = null,
    val countries: List<CountryModel>,
    val genres: List<GenreModel>
)
package com.katerina.morozova.core.utils.responses

import com.katerina.morozova.core.models.MovieModel

data class MovieResponse(
    val pagesCount: Int,
    val films: List<MovieModel>
)
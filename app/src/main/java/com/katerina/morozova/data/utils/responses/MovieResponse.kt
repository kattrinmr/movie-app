package com.katerina.morozova.data.utils.responses

import com.katerina.morozova.data.models.MovieModel

data class MovieResponse(
    val pagesCount: Int,
    val films: List<MovieModel>
)
package com.katerina.morozova.core.utils

import com.katerina.morozova.core.models.MovieModel

data class SearchMovieResponse(
    val keyword: String,
    val pagesCount: Int,
    val films: List<MovieModel>,
    val searchFilmsCountResult: Int
)
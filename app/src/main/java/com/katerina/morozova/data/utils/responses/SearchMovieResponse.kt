package com.katerina.morozova.data.utils.responses

import com.katerina.morozova.data.models.MovieModel

data class SearchMovieResponse(
    val keyword: String,
    val pagesCount: Int,
    val films: List<MovieModel>,
    val searchFilmsCountResult: Int
)
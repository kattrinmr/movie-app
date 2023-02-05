package com.katerina.morozova.domain.interactors

import com.katerina.morozova.domain.repositories.SearchPopularMoviesRepository
import javax.inject.Inject

class SearchPopularMoviesInteractor @Inject constructor(
    private val searchMovieRepository: SearchPopularMoviesRepository
) {
    suspend fun getSearchedMovies(keyword: String) =
        searchMovieRepository.getSearchedMovies(keyword)
}
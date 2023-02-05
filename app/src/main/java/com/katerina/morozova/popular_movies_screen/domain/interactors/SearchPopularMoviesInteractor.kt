package com.katerina.morozova.popular_movies_screen.domain.interactors

import com.katerina.morozova.popular_movies_screen.domain.repositories.SearchPopularMoviesRepository
import javax.inject.Inject

class SearchPopularMoviesInteractor @Inject constructor(
    private val searchMovieRepository: SearchPopularMoviesRepository
) {
    suspend fun getSearchedMovies(keyword: String) =
        searchMovieRepository.getSearchedMovies(keyword)
}
package com.katerina.morozova.popular_movies_screen.domain.interactors

import com.katerina.morozova.popular_movies_screen.domain.repositories.PopularMoviesRepository
import javax.inject.Inject

class PopularMoviesInteractor @Inject constructor(
    private val popularMoviesRepository: PopularMoviesRepository
) {

    suspend fun getPopularMovies() = popularMoviesRepository.getPopularMovies()

}
package com.katerina.morozova.popular_movies_screen.domain.interactors

import com.katerina.morozova.core.models.MovieModel
import com.katerina.morozova.favorite_movies_screen.domain.repositories.FavoriteRepository
import com.katerina.morozova.popular_movies_screen.domain.repositories.PopularMoviesRepository
import javax.inject.Inject

class PopularMoviesInteractor @Inject constructor(
    private val popularMoviesRepository: PopularMoviesRepository,
    private val favoriteMoviesRepository: FavoriteRepository
) {

    suspend fun getPopularMovies() = popularMoviesRepository.getPopularMovies()
    suspend fun insertMovie(movie: MovieModel) = favoriteMoviesRepository.insertMovie(movie)

}
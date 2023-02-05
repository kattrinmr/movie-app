package com.katerina.morozova.popular_movies_screen.domain.interactors

import com.katerina.morozova.core.models.MovieModel
import com.katerina.morozova.popular_movies_screen.domain.repositories.PopularMoviesRepository
import javax.inject.Inject

class PopularMoviesInteractor @Inject constructor(
    private val popularMoviesRepository: PopularMoviesRepository
) {
    suspend fun getPopularMovies() = popularMoviesRepository.getPopularMovies()
    suspend fun insertMovie(movie: MovieModel) = popularMoviesRepository.insertMovie(movie)
    suspend fun removeMovie(movie: MovieModel) = popularMoviesRepository.removeMovie(movie)
    suspend fun checkIfFavourite(movieId: Int) = popularMoviesRepository.isFavourite(movieId)
}
package com.katerina.morozova.favorite_movies_screen.domain.interactors

import com.katerina.morozova.core.models.MovieModel
import com.katerina.morozova.core.utils.responses.StatusResponse
import com.katerina.morozova.popular_movies_screen.domain.repositories.PopularMoviesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoriteInteractor @Inject constructor(
    private val popularMoviesRepository: PopularMoviesRepository
) {
    suspend fun removeMovie(movie: MovieModel) = popularMoviesRepository.removeMovie(movie)
    suspend fun getAllFavoriteMovies(): Flow<StatusResponse<List<MovieModel>>> =
        popularMoviesRepository.getAllFavoriteMovies()
}
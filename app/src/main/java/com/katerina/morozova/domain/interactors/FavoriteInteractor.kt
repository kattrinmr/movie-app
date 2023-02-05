package com.katerina.morozova.domain.interactors

import com.katerina.morozova.data.models.MovieModel
import com.katerina.morozova.data.utils.responses.StatusResponse
import com.katerina.morozova.domain.repositories.PopularMoviesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoriteInteractor @Inject constructor(
    private val popularMoviesRepository: PopularMoviesRepository
) {
    suspend fun removeMovie(movie: MovieModel) = popularMoviesRepository.removeMovie(movie)
    suspend fun getAllFavoriteMovies(): Flow<StatusResponse<List<MovieModel>>> =
        popularMoviesRepository.getAllFavoriteMovies()
}
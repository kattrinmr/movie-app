package com.katerina.morozova.favorite_movies_screen.domain.interactors

import com.katerina.morozova.core.models.MovieModel
import com.katerina.morozova.core.utils.responses.RoomResponse
import com.katerina.morozova.favorite_movies_screen.domain.repositories.FavoriteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoriteInteractor @Inject constructor(
    private val favoriteRepository: FavoriteRepository
) {

    suspend fun insertMovie(movie: MovieModel) = favoriteRepository.insertMovie(movie)
    suspend fun removeMovie(movie: MovieModel) = favoriteRepository.removeMovie(movie)
    suspend fun getAllFavoriteMovies(): Flow<RoomResponse<List<MovieModel>>> =
        favoriteRepository.getAllFavoriteMovies()

}
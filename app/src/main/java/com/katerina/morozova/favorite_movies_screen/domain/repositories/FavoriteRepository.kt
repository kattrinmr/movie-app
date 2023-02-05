package com.katerina.morozova.favorite_movies_screen.domain.repositories

import com.katerina.morozova.core.models.MovieModel
import com.katerina.morozova.core.utils.responses.RoomResponse
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {

    suspend fun insertMovie(movie: MovieModel)
    suspend fun removeMovie(movie: MovieModel)
    suspend fun getAllFavoriteMovies(): Flow<RoomResponse<List<MovieModel>>>

}
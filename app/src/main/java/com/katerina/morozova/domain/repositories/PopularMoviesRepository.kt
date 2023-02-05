package com.katerina.morozova.domain.repositories

import com.katerina.morozova.data.models.MovieModel
import com.katerina.morozova.data.utils.responses.StatusResponse
import kotlinx.coroutines.flow.Flow

interface PopularMoviesRepository {
    suspend fun getPopularMovies(): Flow<StatusResponse<List<MovieModel>>>
    suspend fun insertMovie(movie: MovieModel)
    suspend fun removeMovie(movie: MovieModel)
    suspend fun getAllFavoriteMovies(): Flow<StatusResponse<List<MovieModel>>>
    suspend fun isFavourite(movieId: Int): Boolean
}
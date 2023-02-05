package com.katerina.morozova.favorite_movies_screen.data.repositories

import android.util.Log
import com.katerina.morozova.core.models.MovieModel
import com.katerina.morozova.core.room.daos.MovieDao
import com.katerina.morozova.core.utils.converters.toModelFavorite
import com.katerina.morozova.core.utils.converters.toMovieEntity
import com.katerina.morozova.core.utils.responses.NetworkResponse
import com.katerina.morozova.core.utils.responses.RoomResponse
import com.katerina.morozova.favorite_movies_screen.domain.repositories.FavoriteRepository
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class FavoriteRepositoryImpl @Inject constructor(
    private val movieDao: MovieDao
) : FavoriteRepository {

    override suspend fun insertMovie(movie: MovieModel) {
        movieDao.insertMovie(movie.toMovieEntity())
    }

    override suspend fun removeMovie(movie: MovieModel) {
        movieDao.deleteMovie(movie.toMovieEntity())
    }

    override suspend fun getAllFavoriteMovies(): Flow<RoomResponse<List<MovieModel>>> = flow {
        emit(RoomResponse.Loading(true))
        movieDao.getAllMovies().collect { movieEntities ->
            val movieModels = movieEntities.map { it.toModelFavorite() }
            emit(RoomResponse.Success(movieModels))
        }
    }.catch { e ->
        emit(RoomResponse.Failure(e.message ?: "Unknown error has occurred"))
    }
}




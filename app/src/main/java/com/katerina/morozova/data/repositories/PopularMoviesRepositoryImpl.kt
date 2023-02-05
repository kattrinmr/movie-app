package com.katerina.morozova.data.repositories

import com.katerina.morozova.data.api.MovieApiService
import com.katerina.morozova.data.models.MovieModel
import com.katerina.morozova.data.room.daos.MovieDao
import com.katerina.morozova.data.utils.converters.toModelFavorite
import com.katerina.morozova.data.utils.converters.toMovieEntity
import com.katerina.morozova.data.utils.responses.StatusResponse
import com.katerina.morozova.domain.repositories.PopularMoviesRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PopularMoviesRepositoryImpl @Inject constructor(
    private val apiService: MovieApiService,
    private val movieDao: MovieDao
) : PopularMoviesRepository {

    // Максимальное количество страниц не соответствует значению response.pagesCount,
    // а равно 20. Также я узнала, что есть библиотека Paging Library, но уже не успела внедрить
    // в проект для лучшей оптимизации, так как ранее с ней не работала
    // TODO: Добавить Paging Library

    override suspend fun getPopularMovies() = flow {
        emit(StatusResponse.Loading(true))

        val allMovies = mutableListOf<MovieModel>()

        val maxPage = 10 // max = 20

        for (i in 1..maxPage) {
            val response = apiService.getMovies(page = i)
            allMovies.addAll(response.films.onEach {
                it.isFavorite = isFavourite(it.filmId)
            })
        }
        emit(StatusResponse.Success(allMovies.toList()))

    }.catch { e ->
        emit(StatusResponse.Failure(e.message ?: "Unknown error has occurred"))
    }

    override suspend fun insertMovie(movie: MovieModel) {
        movieDao.insertMovie(movie.toMovieEntity())
    }

    override suspend fun removeMovie(movie: MovieModel) {
        movieDao.deleteMovie(movie.filmId)
    }

    override suspend fun getAllFavoriteMovies() = flow {
        emit(StatusResponse.Loading(true))
        movieDao.getAllMovies().collect { movieEntities ->
            val movieModels = movieEntities.map { it.toModelFavorite() }
            emit(StatusResponse.Success(movieModels))
        }
    }.catch { e ->
        emit(StatusResponse.Failure(e.message ?: "Unknown error has occurred"))
    }

    override suspend fun isFavourite(movieId: Int): Boolean {
        return movieDao.isFavourite(movieId)
    }

}
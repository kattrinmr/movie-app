package com.katerina.morozova.domain.repositories

import com.katerina.morozova.data.models.MovieModel
import com.katerina.morozova.data.utils.responses.StatusResponse
import kotlinx.coroutines.flow.Flow

interface SearchPopularMoviesRepository {
    suspend fun getSearchedMovies(keyword: String): Flow<StatusResponse<List<MovieModel>>>
    suspend fun isFavourite(movieId: Int): Boolean
}
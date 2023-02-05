package com.katerina.morozova.popular_movies_screen.domain.repositories

import com.katerina.morozova.core.models.MovieModel
import com.katerina.morozova.core.utils.responses.StatusResponse
import kotlinx.coroutines.flow.Flow

interface SearchPopularMoviesRepository {
    suspend fun getSearchedMovies(keyword: String): Flow<StatusResponse<List<MovieModel>>>
}
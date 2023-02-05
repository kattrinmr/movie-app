package com.katerina.morozova.popular_movies_screen.domain.repositories

import com.katerina.morozova.core.models.MovieModel
import com.katerina.morozova.core.utils.responses.NetworkResponse
import kotlinx.coroutines.flow.Flow

interface PopularMoviesRepository {

    suspend fun getPopularMovies(): Flow<NetworkResponse<List<MovieModel>>>

}
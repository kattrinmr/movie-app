package com.katerina.morozova.popular_movies_screen.domain.repositories

import com.katerina.morozova.core.models.MovieModel
import com.katerina.morozova.core.utils.responses.NetworkMovieResponse
import kotlinx.coroutines.flow.Flow

interface PopularMoviesRepository {

    suspend fun getPopularMovies(): Flow<NetworkMovieResponse<List<MovieModel>>>

}
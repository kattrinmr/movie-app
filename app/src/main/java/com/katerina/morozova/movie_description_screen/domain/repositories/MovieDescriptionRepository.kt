package com.katerina.morozova.movie_description_screen.domain.repositories

import com.katerina.morozova.core.models.MovieDescriptionModel
import com.katerina.morozova.core.utils.responses.StatusResponse
import kotlinx.coroutines.flow.Flow

interface MovieDescriptionRepository {
    suspend fun getMovieDescription(movieId: Int): Flow<StatusResponse<MovieDescriptionModel>>
}
package com.katerina.morozova.domain.repositories

import com.katerina.morozova.data.models.MovieDescriptionModel
import com.katerina.morozova.data.utils.responses.StatusResponse
import kotlinx.coroutines.flow.Flow

interface MovieDescriptionRepository {
    suspend fun getMovieDescription(movieId: Int): Flow<StatusResponse<MovieDescriptionModel>>
}
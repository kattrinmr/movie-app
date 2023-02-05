package com.katerina.morozova.movie_description_screen.data.repositories

import com.katerina.morozova.core.api.MovieApiService
import com.katerina.morozova.core.models.MovieDescriptionModel
import com.katerina.morozova.core.utils.converters.toModel
import com.katerina.morozova.core.utils.responses.NetworkResponse
import com.katerina.morozova.movie_description_screen.domain.repositories.MovieDescriptionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieDescriptionRepositoryImpl @Inject constructor(
    private val apiService: MovieApiService
) : MovieDescriptionRepository {

    override suspend fun getMovieDescription(movieId: Int): Flow<NetworkResponse<MovieDescriptionModel>> =
        flow {
            emit(NetworkResponse.Loading(true))
            val response = apiService.getMovieDescription(movieId)
            emit(NetworkResponse.Success(response.toModel()))
        }.catch { e ->
            emit(NetworkResponse.Failure(e.message ?: "Unknown error has occurred"))
        }
}
package com.katerina.morozova.popular_movies_screen.data.repositories

import com.katerina.morozova.core.api.MovieApiService
import com.katerina.morozova.core.models.MovieModel
import com.katerina.morozova.core.utils.responses.NetworkResponse
import com.katerina.morozova.popular_movies_screen.domain.repositories.SearchPopularMoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchPopularMoviesRepositoryImpl @Inject constructor(
    private val apiService: MovieApiService
) : SearchPopularMoviesRepository {

    override suspend fun getSearchedMovies(keyword: String): Flow<NetworkResponse<List<MovieModel>>> =
        flow {
            emit(NetworkResponse.Loading(true))
            val response = apiService.getSearchedMovies(keyword, 1)
            emit(NetworkResponse.Success(response.films))
        }.catch { e ->
            emit(NetworkResponse.Failure(e.message ?: "Unknown error has occurred"))
        }

}
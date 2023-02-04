package com.katerina.morozova.popular_movies_screen.data.repositories

import com.katerina.morozova.core.api.MovieApiService
import com.katerina.morozova.core.models.MovieModel
import com.katerina.morozova.core.utils.NetworkResponse
import com.katerina.morozova.popular_movies_screen.domain.repositories.PopularMoviesRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PopularMoviesRepositoryImpl @Inject constructor(
    private val apiService: MovieApiService
) : PopularMoviesRepository {

    // Максимальное количество страниц не соответствует значению response.pagesCount,
    // а равно 20.
    override suspend fun getPopularMovies() = flow {
        emit(NetworkResponse.Loading(true))

        val allMovies = mutableListOf<MovieModel>()

        var response = apiService.getMovies(page = 1)
        allMovies.addAll(response.films)

        val maxPage = 10 // max = 20

        for (i in 2..maxPage) {
            response = apiService.getMovies(page = i)
            allMovies.addAll(response.films)
        }
        emit(NetworkResponse.Success(allMovies.toList()))

    }.catch { e ->
        emit(NetworkResponse.Failure(e.message ?: "Unknown error has occurred"))
    }

}
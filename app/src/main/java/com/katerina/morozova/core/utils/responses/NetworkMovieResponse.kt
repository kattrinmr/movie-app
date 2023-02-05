package com.katerina.morozova.core.utils.responses

sealed class NetworkMovieResponse<T> {
    data class Loading<T>(val isLoading: Boolean) : NetworkMovieResponse<T>()
    data class Success<T>(val data: T) : NetworkMovieResponse<T>()
    data class Failure<T>(val errorMessage: String) : NetworkMovieResponse<T>()
}
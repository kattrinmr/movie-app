package com.katerina.morozova.core.utils

sealed class NetworkResponse<T> {
    data class Loading<T>(val isLoading: Boolean) : NetworkResponse<T>()
    data class Success<T>(val data: T) : NetworkResponse<T>()
    data class Failure<T>(val errorMessage: String) : NetworkResponse<T>()
}
package com.katerina.morozova.core.utils.responses

sealed class RoomResponse<T> {
    data class Loading<T>(val isLoading: Boolean) : RoomResponse<T>()
    data class Success<T>(val data: T) : RoomResponse<T>()
    data class Failure<T>(val errorMessage: String) : RoomResponse<T>()
}
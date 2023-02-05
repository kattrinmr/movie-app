package com.katerina.morozova.core.utils.responses

sealed class NetworkResponse {
    object Available : NetworkResponse()
    object Unavailable : NetworkResponse()
}
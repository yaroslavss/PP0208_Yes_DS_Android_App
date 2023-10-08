package ru.yesds.yesdsapp.util

sealed class ApiResponse<T>(
    data: T? = null,
    message: String? = null
) {
    data class Success<T>(val data: T) : ApiResponse<T>(data, null)

    data class Error<T>(
        val message: String?
    ) : ApiResponse<T>(null, message)

    class Loading<T> : ApiResponse<T>()
}
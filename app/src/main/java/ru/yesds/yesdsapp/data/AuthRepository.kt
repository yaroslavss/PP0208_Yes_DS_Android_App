package ru.yesds.yesdsapp.data

import ru.yesds.yesdsapp.data.model.AuthResponse
import ru.yesds.yesdsapp.domain.model.User
import ru.yesds.yesdsapp.util.ApiResponse

interface AuthRepository {
    suspend fun signIn(user: User): ApiResponse<AuthResponse>
}
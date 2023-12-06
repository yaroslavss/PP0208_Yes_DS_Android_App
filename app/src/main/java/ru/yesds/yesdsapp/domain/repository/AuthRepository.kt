package ru.yesds.yesdsapp.domain.repository

import retrofit2.Response
import ru.yesds.yesdsapp.data.model.AuthResponse
import ru.yesds.yesdsapp.domain.model.User

interface AuthRepository {
    suspend fun signIn(user: User): Response<AuthResponse>
}
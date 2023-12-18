package ru.yesds.yesdsapp.domain.repository

import retrofit2.Response
import ru.yesds.yesdsapp.data.model.AuthResponse
import ru.yesds.yesdsapp.domain.model.UserLogin

interface AuthRepository {
    suspend fun signIn(userLogin: UserLogin): Response<AuthResponse>
}
package ru.yesds.yesdsapp.data

import retrofit2.Response
import ru.yesds.yesdsapp.data.model.AuthResponse
import ru.yesds.yesdsapp.model.User

interface AuthApi {
    suspend fun signIn(user: User): Response<AuthResponse>
}
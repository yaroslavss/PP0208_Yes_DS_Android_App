package ru.yesds.yesdsapp.data

import retrofit2.Response
import ru.yesds.yesdsapp.data.Constants.AUTH_BASE_URL
import ru.yesds.yesdsapp.data.model.AuthResponse
import ru.yesds.yesdsapp.domain.model.User

class AuthApiImpl : AuthApi {
    override suspend fun signIn(user: User): Response<AuthResponse> {
        return RetrofitInstance.authApi.signIn(user, AUTH_BASE_URL+"auth/login")
    }
}